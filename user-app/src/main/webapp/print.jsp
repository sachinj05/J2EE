<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Your Details are displayed below</h1>
<h1>Id: <%=request.getAttribute("id") %></h1>
<h1>Name: <%=request.getAttribute("name") %></h1>
<h1>Age: <%=request.getAttribute("age") %></h1>
<h1>Phone Number: <%=request.getAttribute("phone") %></h1>
</body>
</html>