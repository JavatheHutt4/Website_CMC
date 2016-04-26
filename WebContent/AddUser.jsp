<%@include file="VerifyAdmin.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User </title>
<style type="text/css">
#panel {
border-radius: 10px;
padding: 10px;
margin-right: 80px;
margin-left: 80px;
background-color: silver;
color: #0e0d0d;
font-size: xx-large;
}
#panel2 {
border-radius: 10px;
padding: 10px;
margin-right: 80px;
margin-left: 80px;
background-color: silver;
color: #0e0d0d;
}
body {
background-color: #020202;
color: #fdfdfd;
}

</style>
</head>
<body>
<form  action="Logout_action.jsp" name="logout">
<p id="panel" style="text-align: center;">
<a href="AdminMenu.jsp">
<img style="width: 64px; height: 64px; font-family: Draft Beer;"alt="CMCLogo" src="img/CMCLogo.png" align="left">
</a>
<font size="+3">Add User <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<p style="text-align:center">
<%
String error = request.getParameter("Error");
if (error !=null){
	int errorNum = Integer.parseInt(error);
	if (errorNum==-1){
		out.println("MEMBER TYPE MUST BE EITHER: \n'a' for admin or 'u' for user");
	}
	else if (errorNum==-2){
		out.println("Username is already taken. Please try another username");
	}
}
%>
</p>
<div id="panel2">
<form method="post" action="AddUser_action.jsp" name="adduser">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;text-align:left;">First Name:</td>
<td><input name="first"></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Last Name:</td>
<td><input name="last"></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Username:</td>
<td><input name="username"></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Password:</td>
<td><input name="password"></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Type:</td>
<td><input name="type"></td>
</tr>
</tbody>
</table>
<input type="submit" value="Add User"><input type="reset">
</form>
</div>

</body>
</html>