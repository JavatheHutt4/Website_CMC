<%@include file="VerifyUser.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View School </title>
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
<p id="panel" style="text-align: center;">
<a href="UserMenu.jsp">
<img 
style="width: 64px; height: 64px; font-family: Draft Beer;"
alt="CMCLogo" src="img/CMCLogo.png" align="left">
</a>
<font size="+3">VIEW SCHOOL <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<%
String name = request.getParameter("School");
SchoolHome sh = new SchoolHome(); 
School school = sh.findByName(name);
%>
<div id="panel2">
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;text-align:center;" colspan="8">
School Information
</td>
</tr>
<tr>
<td>SCHOOL:</td>
<td><input name="school" value = "<%=school.getName() %>" readonly></td>
</tr>
<tr>
<td>STATE:</td>
<td><input name="state" value = "<% out.println(school.getState()); %>" readonly></td>
</tr>
<tr>
<td>LOCATION:</td>
<td><input name="location" value = "<% out.println(school.getLocation()); %>" readonly></td>
</tr>
<tr>
<td>CONTROL:</td>
<td><input name="control" value = "<% out.println(school.getControl()); %>" readonly></td>
</tr>
<tr>
<td>NUMBER OF STUDENTS:</td>
<td><input name="students" value = <% out.println(school.getNumStudents()); %> readonly></td>
</tr>
<tr>
<td>% FEMALE:</td>
<td><input name="female" value = <% out.println(school.getPerFemale()); %> readonly></td>
</tr>
<tr>
<td>SAT VERBAL:</td>
<td><input name="satverbal" value = <% out.println(school.getSatVerbal()); %> readonly></td>
</tr>
<tr>
<td>SAT MATH:</td>
<td><input name="satmath" value = <% out.println(school.getSatMath()); %> readonly></td>
</tr>
<tr>
<td>EXPENSES:</td>
<td><input name="expenses" value = <% out.println(school.getExpenses()); %> readonly></td>
</tr>
<tr>
<td>% FINANCIAL AID:</td>
<td><input name="financial" value = <% out.println(school.getPerFinancial()); %> readonly></td>
</tr>
<tr>
<td>NUMBER OF APPLICANTS:</td>
<td><input name="numApplicants" value =<% out.println(school.getNumApplicants()); %> readonly></td>
</tr>
<tr>
<td>% ADMITTED:</td>
<td><input name="admitted" value = <% out.println(school.getPerAdmitted()); %>readonly></td>
</tr>
<tr>
<td>% ENROLLED:</td>
<td><input name="enrolled" value = <% out.println(school.getPerEnrolled()); %> readonly></td>
</tr>
<tr>
<td>ACADEMIC SCALE (1-5):</td>
<td><input name="acad" value = <% out.println(school.getAcadScale()); %> readonly></td>
</tr>
<tr>
<td>SOCIAL SCALE (1-5):</td>
<td><input name="social" value = <% out.println(school.getSocialScale()); %> readonly></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE (1-5):</td>
<td><input name="qol" value = <% out.println(school.getQOLScale()); %> readonly></td>
</tr>
<tr>
<td>EMPHASES: </td>
<td>
<%
String[] emphases = school.getEmphasis();
for (int i = 0; i < emphases.length; i++){
	//System.out.println(emphases[i]);
	if(emphases[i]==null)
		break;
	out.println("<input name=\"emphasis"+i+"\" value =\""+emphases[i]+"\" readonly><br>");
}
%>
</td>
</tr>

</table>
</div>

</body>