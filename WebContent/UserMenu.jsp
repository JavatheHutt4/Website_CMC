<%@include file="VerifyUser.jsp"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>UserUI</title>
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
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">USER
INTERFACE <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<p style ="text-align: center;">
<% String errorParam = request.getParameter("Error");
if (errorParam != null){
	int error = Integer.parseInt(errorParam);
	if (error == -1){
		out.println("YOU CANNOT ACCESS THAT PAGE WITH CURRENT PERMISSIONS.<br>");
	}
	if (error == -2){
		out.println("Profile Changed Successfully.<br>");
	}
}
%>
</p>
<div id="panel">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top; text-align: center;">
<form method="post" action="ManageProfile.jsp"
name="ManageProfile"><input name="manageprofile" value="Manage Profile"
type="submit"></form>
</td> 
<td style="vertical-align: top; text-align: center;">
<form method="post" action="ManageSchools.jsp"
name="ManageSchools"> <input name="manageschools"
value="Manage Schools" type="submit"></form>
</td>
<td style="vertical-align: top; text-align: center;">
<form method="post" action="SearchSchools.jsp"
name="SearchSchools"> <input name="searchschools"
value="Search Schools" type="submit"></form>
</td>
</tr>
</tbody>
</table>
</div>
</body>
</html>
