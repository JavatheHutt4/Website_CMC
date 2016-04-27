<%@include file="VerifyUser.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>View Searched School</title>
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
color: #0e0d0d;
}

</style>
</head>
<body>
<form method="post" action="Logout_action.jsp" name="logout">
<p id="panel" style="text-align: center;"><a href="UserMenu.jsp">
<img 
style="width: 64px; height: 64px; font-family: Draft Beer;"
alt="CMCLogo" src="img/CMCLogo.png" align="left">
</a><font size="+3">VIEW SEARCHED SCHOOL <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<div id="panel">
<% 

String schoolName = request.getParameter("SchoolName");

SchoolHome sh = new SchoolHome();
UserUI ui = new UserUI();
School school = sh.findByName(schoolName);
String[][] recommendedSchools = ui.recommendSchool(sh.findByName(schoolName));

%>
<%=schoolName%>
<table style="text-align: center; width: 100%;" border="1" >
<tbody>
<tr>
<td>SCHOOL:</td>
<td><input name="school" value = "<% out.println(school.getName()); %>" readonly></td>
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
<tr>
<td>
<form method="post" action="Save_action.jsp" name="Save School">
<input name="saveSchool"
	value="Save" type="submit">
    <input name="SchoolName" value="<%=schoolName %>" type="hidden">
</form>
</td>
<td>
</td>
</tbody>
</table>
<br>
<br>
MAY WE ALSO RECOMMEND:
<%for(int j = 0; j < recommendedSchools.length; j++){ 
	School school2 = sh.findByName(recommendedSchools[j][0]);%>
<table style="text-align: center; width: 100%;" border="1" >
<tbody>
<tr>
<td>SCHOOL:</td>
<td><input name="school" value = "<% out.println(school2.getName()); %>" readonly></td>
</tr>
<tr>
<td>STATE:</td>
<td><input name="state" value = "<% out.println(school2.getState()); %>" readonly></td>
</tr>
<tr>
<td>LOCATION:</td>
<td><input name="location" value = "<% out.println(school2.getLocation()); %>" readonly></td>
</tr>
<tr>
<td>CONTROL:</td>
<td><input name="control" value = "<% out.println(school2.getControl()); %>" readonly></td>
</tr>
<tr>
<td>NUMBER OF STUDENTS:</td>
<td><input name="students" value = <% out.println(school2.getNumStudents()); %> readonly></td>
</tr>
<tr>
<td>% FEMALE:</td>
<td><input name="female" value = <% out.println(school2.getPerFemale()); %> readonly></td>
</tr>
<tr>
<td>SAT VERBAL:</td>
<td><input name="satverbal" value = <% out.println(school2.getSatVerbal()); %> readonly></td>
</tr>
<tr>
<td>SAT MATH:</td>
<td><input name="satmath" value = <% out.println(school2.getSatMath()); %> readonly></td>
</tr>
<tr>
<td>EXPENSES:</td>
<td><input name="expenses" value = <% out.println(school2.getExpenses()); %> readonly></td>
</tr>
<tr>
<td>% FINANCIAL AID:</td>
<td><input name="financial" value = <% out.println(school2.getPerFinancial()); %> readonly></td>
</tr>
<tr>
<td>NUMBER OF APPLICANTS:</td>
<td><input name="numApplicants" value =<% out.println(school2.getNumApplicants()); %> readonly></td>
</tr>
<tr>
<td>% ADMITTED:</td>
<td><input name="admitted" value = <% out.println(school2.getPerAdmitted()); %>readonly></td>
</tr>
<tr>
<td>% ENROLLED:</td>
<td><input name="enrolled" value = <% out.println(school2.getPerEnrolled()); %> readonly></td>
</tr>
<tr>
<td>ACADEMIC SCALE (1-5):</td>
<td><input name="acad" value = <% out.println(school2.getAcadScale()); %> readonly></td>
</tr>
<tr>
<td>SOCIAL SCALE (1-5):</td>
<td><input name="social" value = <% out.println(school2.getSocialScale()); %> readonly></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE (1-5):</td>
<td><input name="qol" value = <% out.println(school2.getQOLScale()); %> readonly></td>
</tr>
<tr>
<td>EMPHASES: </td>
<td>
<%
String[] emphases2 = school.getEmphasis();
for (int i = 0; i < emphases2.length; i++){
	if(emphases2[i]==null)
		break;
	out.println("<input name=\"emphasis"+i+"\" value =\""+emphases2[i]+"\" readonly><br>");
}
%>
</td>
</tr>
<tr>
<td>
<form method="post" action="Save_action.jsp" name="Save School">
<input name="saveSchool"
	value="Save" type="submit">
    <input name="SchoolName" value="<%=school2.getName() %>" type="hidden">
</form>
</td>
<td>
</td>
</tbody>
</table>
<br>
<% } %>
</div>
</body>
</html>