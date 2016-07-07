<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.Shanklish.UserDatabase.DAOuser"%>  
<%@ page import="com.Shanklish.UserDatabase.user"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Users</title>
</head>
<body>
<h1>User List</h1>

<jsp:useBean id="obj" class="com.Shanklish.UserDatabase.user"></jsp:useBean>
  
<jsp:setProperty property="*" name="obj"/>

<table>


<%  
List <user> users = DAOuser.getAllUsers();      //JSP

for (user u: users) {
    out.println ("<tr><td>" + u.getFullname() + "</td><td>" +
        u.getUsername() + "</td><td>" + u.getEmail()
        + "</td><td>" + "</td></tr>");
}
%>

  
</table>
</body>
</html>