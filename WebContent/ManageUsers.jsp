<%@include file="VerifyAdmin.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Users </title>
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
<form method="post" action="Logout_action.jsp" name="logout">
<p id="panel" style="text-align: center;"><img 
style="width: 64px; height: 64px; font-family: Draft Beer;"
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">MANAGE USERS <input name="logout" value="Logout" type="submit"></font> </p>
</form>

<div id="panel2">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;text-align:center;" colspan="8">
<form method="post" action="AddUser.jsp" name="addUser"><input name="AddUser"
value="Add User" type="submit"> </form>
</td>
</tr>
<tr>
<td style="vertical-align: top;">
</td>
<td style="vertical-align: top;text-align: center;">First
</td>
<td style="vertical-align: top;text-align: center;">Last
</td>
<td style="vertical-align: top;text-align: center;">Username
</td>
<td style="vertical-align: top;text-align: center;">Password
</td>
<td style="vertical-align: top;text-align: center;">Type
</td>
<td style="vertical-align: top;text-align: center;">Status
</td>
<td style="vertical-align: top;">
</td>
</tr>

<%
AdminUI au = new AdminUI();
String[][] users = au.getUsers();
for (int i = 0; i < users.length; i ++){
	out.println("<tr><td><form action=\"EditUser.jsp?User="+users[i][0]+"\" name=\"edit\"><input name=\"Edit\""
			+"value=\"Edit\" type=\"submit\"><br>"
			+"</form></td>");
	for (int j = 0; j < users[i].length; j++){
		out.println("<td>"+users[i][j]+"</td>");
	}
	out.println("<td><form action=\"DeactivateUser_action.jsp?User="+users[i][0]+"\" name=\"deactivate\"><input name=\"Deactivate\""
			+"value=\"Deactivate\" type=\"submit\"><br>"
			+"</form></td></tr>");
}
%>

</div>
</tbody>
</table>

</body>
</html>