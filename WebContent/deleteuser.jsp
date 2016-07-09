<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.Shanklish.UserDatabase.DAOuser"%>  <!-- INSERT DAO HERE* -->

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Database</title>
</head>
<body>
<h1>User Deleted</h1>

<jsp:useBean id="obj" class="com.Shanklish.UserDatabase.user">  
</jsp:useBean>  
<jsp:setProperty property="*" name="obj"/> 

<%  
//DAOuser.deleteUser(obj); 

int i= Integer.parseInt(request.getParameter("userid"));

DAOuser.deleteUserByID(i);

%>  
</body>
</html>