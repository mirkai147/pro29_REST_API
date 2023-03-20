<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home </title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(function() {
        $("#checkJson").click(function() {
            let member = {
                id:"park",
                name:"박지성",
                pwd:"1234",
                email:"park@test.com"
            };
            $.ajax({
                type:"post",
                url:"${contextPath}/test/info",
                contentType:"application/json",
                data:JSON.stringify(member),
                success:function(data,textStatus){},
                error:function(data,textStatus){
                    alert("에러가 발생했습니다.");
                },
                complete:function(data,textStatus){}
            });
        });
    });
</script>
</head>
<body>
    <input type="button" id="checkJson" value="회원정보 보내기"/><br><br>
    <div id="output"></div>
</body>
</html>