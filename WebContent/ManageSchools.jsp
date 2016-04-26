<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Schools </title>
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
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">MANAGE SCHOOLS <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<p style ="text-align:center;">
<% 
String msg = request.getParameter("msg");
if (msg!=null){
	int msgNum = Integer.parseInt(msg);
	if (msgNum == 1)
		out.println("School has successfully been removed from your saved schools");
}
%>
</p>
<div id="panel2">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;text-align:center;" colspan="8">
School
</td>
<%
LogonController lc = (LogonController) session.getAttribute("lc");
User user = (User) lc.getMember();
ArrayList<String> schools = user.getSavedSchools();
for (int i = 0; i < schools.size(); i ++){
	out.println("<tr><td><form action=\"RemoveSchool_action.jsp\" name=\"remove\"><input name=\"Remove\""
			+"value=\"Remove\" type=\"submit\"><input name = \"School\" value =\""+schools.get(i)+"\" type= \"hidden\"><br>"
			+"</form></td>");
	out.println("<td>"+schools.get(i)+"</td>");
	out.println("<td><form action=\"ViewSchool.jsp\" name=\"view\"><input name=\"View\""
			+"value=\"View\" type=\"submit\"><input name = \"School\" value =\""+schools.get(i)+"\" type= \"hidden\"><br>"
			+"</form></td></tr>");
}
%>
</tbody>
</table>
</div>

</body>
</html>