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
if(name!=null){
%>
<h1>
Welcome Mr.<%= name %></h1>
<h2>
<a href="edit.jsp">Edit your account</a>	
</h2>
<h2>
<a href="delete?id=<%=session.getAttribute("id")%>">Delete Your Account</a>
</h2>
<h2>
<a href="view.jsp">View your Profile</a>
</h2>
<h2>
<a href="logout">LOGOUT</a>
</h2>
<%
 }else{
	 response.sendRedirect("login.jsp");
   }
%>
</body>
</html>