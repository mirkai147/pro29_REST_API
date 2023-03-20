package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//REST ��� ����ϱ� ���� ������ �����ӿ�ũ 4.1.1�� pom���� ����
@RestController
@RequestMapping("/test/*")
public class TestController {

	static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/fsdsfda")
	public String dddfadf() {
		return "asdfdsfafdasfdsdfafdassdfafdsasafda";
	}
	
	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO member = new MemberVO();
		member.setId("hong");
		member.setPwd("1234");
		member.setName("ȫ�浿");
		member.setEmail("hong@adfsdfak");
		return member; 
	}
	
	@RequestMapping("/membersList")
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i=0; i<10; i++) {
			
			MemberVO vo = new MemberVO();
			vo.setId("hong" + i);
			vo.setPwd("1234");
			vo.setName("ȫ�浿" + i);
			vo.setEmail("hong@gil.dong");
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap(){
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		
		for(int i=0; i<10; i++) {
			
			MemberVO vo = new MemberVO();
			vo.setId("hong" + i);
			vo.setPwd("1234");
			vo.setName("ȫ�浿" + i);
			vo.setEmail("hong@gil.dong");
			map.put(i, vo);
		}
		return map;
	}
	
	//Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for RequestMapping annotated handler methods.
	@RequestMapping(value = "/notice1/{num}", method = RequestMethod.GET)
	public int notice1(@PathVariable(value = "num") int num) throws Exception{
		
		return num;
		
	}
	@RequestMapping(value = "/notice2/{str}", method = RequestMethod.GET)
	public String notice2(@PathVariable(value = "str") String str) throws Exception{
		
		return str;
		
	}
	
	//HttpMessageConverter
	//Strategy interface that specifies a converter that can convert from and to HTTP requests and responses.
	
	//@RequestBody
	//Annotation indicating a method parameter should be bound to the body of the web request.
	//The body of the request is passed through an HttpMessageConverter to resolve themethod argument depending on the content type of the request.
	//Optionally, automaticvalidation can be applied by annotating the argument with @Valid. 
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo) {
		logger.info(vo.toString());
	}
	//@RestController는 별도의 View를 제공하지 않은 채 데이터를 전달하므로 전달 과정에서 예외가 발생 할 수 있다.
	//예외에 대해 좀 더 세밀한 제어가 필요할 경우 ResponseEntity 클래스를 사용
	//ResponseEntity에 HTTP 상태코드를 설정하여 전송할 수 있다.
	//옆에서 HTTP 상태 코드를 인식할 수 있는 기능을 이용해 주문상태나 예외발생을 알려줌.
	//Extension of HttpEntity that adds a HttpStatus status code. Used in RestTemplate as well @Controller methods. 
	@RequestMapping("/membersList2")
	public ResponseEntity<MemberVO> listMembers2(){
		MemberVO vo = new MemberVO();
		vo.setId("asdf");
		vo.setPwd("1234");
		vo.setName("sdf");
		vo.setEmail("1231gteadf");
		return new ResponseEntity<MemberVO>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("/res3")
	public ResponseEntity res3() {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "text/html; charset=utf-8");
		String message = "<script>";
		message += " alert('새 회원을 등록합니다.');";
		message += " location.href='/pro29/test/membersList2';";
		message += " </script>";
		return new ResponseEntity(message, resHeaders, HttpStatus.CREATED);
	}
	
}
