<%@include file="VerifyAdmin.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
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

<% 
AdminUI aui = new AdminUI();
String username = request.getParameter("User");
Member member = aui.findByName(username);
String first = member.getFirstName();
String last = member.getLastName();
String password= member.getPassword();
char type = member.getType();
char status= member.getStatus();
%>

<body>

<form  action="Logout_action.jsp" name="logout">
<p id="panel" style="text-align: center;"><img
style="width: 64px; height: 64px; font-family: Draft Beer;"
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">Edit User <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<p style ="text-align:center;">
<%
String error = request.getParameter("Error");
if (error != null){
	int errorNum = Integer.parseInt(error);
	if (errorNum == -1){
		out.println("Invalid entry for type. Please enter either 'a' or 'u'");
	}
	else if (errorNum == -2){
		out.println("Invalid entry for status. Please enter either 'Y' or 'N'");
	}
}
%>
</p>
<div id="panel2">
<form method="post" action="EditUser_action.jsp" name="edituser">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;text-align:left;">First Name:</td>
<td><input name="first" value = <%out.println(first);%>></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Last Name:</td>
<td><input name="last" value = <%out.println(last);%>></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Username:</td>
<td><input name="username" value = <%out.println(username);%> readonly></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Password:</td>
<td><input name="password" value = <%out.println(password);%>></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Type:</td>
<td><input name="type" value = <%out.println(type);%>></td>
</tr>
<tr>
<td style="vertical-align: top;text-align:left;">Status:</td>
<td><input name="status" value = <%out.println(status);%>></td>
</tr>
</tbody>
</table>
<input type="submit" value="Edit User"><input type="reset">
</form>
</div>
</body>
</html>