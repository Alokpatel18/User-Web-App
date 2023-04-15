<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String) session.getAttribute("name");
int id = (int) session.getAttribute("id");
long phone = (long) session.getAttribute("phone");
int age = (int) session.getAttribute("age");
String password = (String) session.getAttribute("password");
if (name != null){
%>
<form action="edit" method="post">
ID<input type="number" name="id" value="<%=id %>" readonly="readonly"> <br>

Name<input type="text" name="nm" value = "<%=name%>"><br>

Age<input type="number" name="age" value="<%=age %>"><br>

Phone Number:<input type = "tel" name="ph" value="<%=phone %>"><br>

Password:<input type="password" name="ps" value="<%=password %>"><br>


<input type = "submit" value="Update" >
</form>
<%
} else {
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>