package com.myspring.pro29.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러에서 @RestController를 이용하여 메서드에서 요청 url로 요청하면 JSP를 통해 뷰리졸버로 리턴한 후 브라우저에 결과 표시
//하지만 그냥 @Controller로 하고 특정 메서드에 @ResponseBody를 적용하면 JSP가 아닌 텍스트나 JSON으로 결과를 전송할 수 있다. 암기 * X 100 !!!
@Controller
public class ResController {
	
	@RequestMapping("/res1")
	@ResponseBody
	public Map<String, Object> res1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "홍길동");
		return map;
	}
	
	@RequestMapping("/res2")
	public ModelAndView res2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
