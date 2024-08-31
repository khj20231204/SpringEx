<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="com.fastcampus.ch2.*" %>

<% 
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "김현진");
	request.setAttribute("list", new java.util.ArrayList());
%>

<html>
	<head>
		<title>EL</title>
	</head>
</html>
<body>
person.getCar().getColor() = <%= person.getCar().getColor() %><br>
person.getCar().getColor() = ${person.getCar().getColor()} <br>
person.getCar().getColor() = ${person.car.color } <br>

name = <%= request.getAttribute("name") %>
name = ${name} <br>
name = ${ request.getAttribute("name")} <br>

id = <%= request.getParameter("id") %> <br>
id = ${pageContext.request.getParameter("id") } <br>
id = ${param.id} <br> 
</body>