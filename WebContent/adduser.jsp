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
<h1>User Database</h1>

<jsp:useBean id="obj" class="com.Shanklish.UserDatabase.user">  
</jsp:useBean>  
<jsp:setProperty property="*" name="obj"/> 

<%  
int i=DAOuser.addUser(obj); 

if (i > 0)  
    out.print("Credentials successfully added");  
else
    out.println("Error; credentials not added");
%>  
</body>
</html>