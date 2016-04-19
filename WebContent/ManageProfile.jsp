<%@include file="Verify.jsp"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Manage Profile</title>
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
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">Manage
My
Profile <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<br>
<%User user = (User) lc.getMember();%>
<div id="panel">
<form style="height: 301px;" method="post"
action="ManageProfile_action.jsp" name="ManageProfile">
<table
style="text-align: left; width: 450px; background-color: white; margin-left: auto; margin-right: auto; height: 250px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top; height: 50px;"><span
style="color: black;">First
Name:</span><br>
</td>
<td style="vertical-align: top; color: black; height: 50px;"><input
name="firstName" value="<%=user.getFirstName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; height: 50px;"><span
style="color: black;">Last
Name:</span><br>
</td>
<td style="vertical-align: top; color: black; height: 50px;"><input
name="lastName" value="<%=user.getLastName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><span style="color: black;">Username:</span><br>
</td>
<td style="vertical-align: top; color: black;"><input
name="userName" value="<%=user.getUserName()%>" readonly></td>
</tr>
<tr>
<td style="vertical-align: top;"><span style="color: black;">Password:</span><br>
</td>
<td style="vertical-align: top; color: black;"><input
name="password" value="<%=user.getPassword()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><span style="color: black;">Type:</span><br>
</td>
<td style="vertical-align: top; color: black;"><span
style="color: black;"><input
name="type" value="u" readonly></span><br>
</td>
</tr>
</tbody>
</table>
<div style="text-align: center;">&nbsp; <input value="Submit Changes"
name="submit" type="submit"> <input name="reset" value="Reset"
type="reset"><br>
</div>
</form>
</div>
</body>
</html>
