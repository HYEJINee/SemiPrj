<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.customerDto"%>
<%@page import="model.BoardDto"%>
<%@page import="dbcp.DBConnectionMgr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<title>마이페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/card3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<script>
	$(document).ready(function() {
		$("#test1").click(function() { //id test1 이라는 a태그 클릭시 발생
			$("#view").submit(); // view라는 id를 가진 form을 submit 전송
		});
		$("#test2").click(function() { 
			$("#mywrite").submit(); 
		});
		$("#test3").click(function() { 
			$("#message").submit();
		});
	});
</script>
<body>
	<% customerDto emp = (customerDto) session.getAttribute("list"); %>
	<div class="container">
	<div>
		<div style="position: relative; top: 200px; left: 900px;  z-index: 2;">
			<img <%if (emp.getUser_profile().equals("null")) {%> src="nomal.jpg"
				<%} else {%> src="/semiProject/upload/<%=emp.getUser_profile()%>"
				<%}%> class="img-thumbnail" id="Inputimage" name="Inputimage"
				style="height: 100px; width: 100px" />
		</div>
		<img <%if (emp.getUser_hearder().equals("null")) {%> src="back.jpg"
			<%} else {%> src="/semiProject/upload/<%=emp.getUser_hearder()%>"
			<%}%> class="img-rounded" id="Inputback" name="Inputback"
			style="height: 250px; width: 100%" />
	</div>
		<form>
			<nav class="navbar navbar-default">
			<ul class="nav nav-pills col-md-offset-4">
				<li><a href="#" id="test1">개인정보수정</a></li>
				<li><a href="#" id="test2">내가 작성한 글</a></li>
				<li><a href="#" id="test3">알림</a></li>
				<li><a href="#" id="test4">팔로잉</a></li>
				<li><a href="#" id="test5">팔로우</a></li>
				<li><a href="#" id="test6">좋아요</a></li>
			</ul>
			</nav>
		</form>
		</div>
	<div class="container">
		<%
			String BodyPage = "/WEB-INF/views/customer/MyMessage.jsp";
			if (request.getParameter("page") != null) {
				BodyPage = request.getParameter("page");
			}
		%>
		<jsp:include page="<%=BodyPage%>" flush="false" />
	</div>
	<form action="customer.do" id="view" method="post">
		<input type="hidden" name="param" value="view" /> <input
			type="hidden" name="view" value="<%=emp.getUser_email()%>" /> <input
			type="hidden" name="page" value="Myupdate.jsp" />
	</form>

	<form action="customer.do" id="mywrite" method="post">
		<input type="hidden" name="param" value="mywrite" /> <input
			type="hidden" name="mywrite" value="<%=emp.getUser_email()%>" /> <input
			type="hidden" name="page" value="Mywrite.jsp" />
	</form>
	<form action="customer.do" id="message" method="post">
		<input type="hidden" name="param" value="message" /> <input
			type="hidden" name="message" value="<%=emp.getUser_email()%>" /> <input
			type="hidden" name="page" value="MyMessage.jsp" />
	</form>

</body>
</html>