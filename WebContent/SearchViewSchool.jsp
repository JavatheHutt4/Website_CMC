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
<p id="panel" style="text-align: center;"><img
style="width: 64px; height: 64px; font-family: Draft Beer;"
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">VIEW SEARCHED SCHOOL <input name="logout" value="Logout" type="submit"></font> </p>
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
<td>SCHOOL NAME</td>
<td><%=school.getName()%>
</td>
</tr>
<tr>
<td>STATE</td>
<td><%=school.getState()%></td>
</tr>
<tr>
<td>LOCATION</td>
<td><%=school.getLocation() %></td>
</tr>
<tr>
<td>CONTROL</td>
<td><%=school.getControl() %></td>
</tr>
<tr>
<td>NUMBER OF STUDENTS</td>
<td><%=school.getNumStudents() %></td>
</tr>
<tr>
<td>PERCENT FEMALE</td>
<td><%=school.getPerFemale() %></td>
</tr>
<tr>
<td>SAT VERBAL</td>
<td><%=school.getSatVerbal() %></td>
</tr>
<tr>
<td>SAT MATH</td>
<td><%=school.getSatMath() %></td>
</tr>
<tr>
<td>EXPENSES</td>
<td><%=school.getExpenses() %></td>
</tr>
<tr>
<td>PERCENT FINANCIAL AID</td>
<td><%=school.getPerFinancial() %></td>
</tr>
<tr>
<td>NUMBER OF APPLICANTS</td>
<td><%=school.getNumApplicants()%></td>
</tr>
<tr>
<td>PERCENT ADMITTED</td>
<td><%=school.getPerAdmitted() %></td>
</tr>
<tr>
<td>PERCENT ENROLLED</td>
<td><%=school.getPerEnrolled() %></td>
</tr>
<tr>
<td>ACADEMICS SCALE (1-5)</td>
<td><%=school.getAcadScale() %></td>
</tr>
<tr>
<td>SOCIAL SCALE (1-5)</td>
<td><%=school.getSocialScale() %></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE (1-5)</td>
<td><%=school.getQOLScale() %></td>
</tr>
<tr>
<td>EMPHASES</td>
<td>
<%String[] emphases = school.getEmphasis();
for(int i = 0; i < emphases.length; i++){
	if(emphases[i]!=null)
	out.println(emphases[i]+"<br>");
} %>
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
<td>SCHOOL NAME</td>
<td><%=school2.getName()%>
</td>
</tr>
<tr>
<td>STATE</td>
<td><%=school2.getState()%></td>
</tr>
<tr>
<td>LOCATION</td>
<td><%=school2.getLocation()%></td>
</tr>
<tr>
<td>CONTROL</td>
<td><%=school2.getControl()%></td>
</tr>
<tr>
<td>NUMBER OF STUDENTS</td>
<td><%=school2.getNumStudents()%></td>
</tr>
<tr>
<td>PERCENT FEMALE</td>
<td><%=school2.getPerFemale()%></td>
</tr>
<tr>
<td>SAT VERBAL</td>
<td><%=school2.getSatVerbal() %></td>
</tr>
<tr>
<td>SAT MATH</td>
<td><%=school2.getSatMath() %></td>
</tr>
<tr>
<td>EXPENSES</td>
<td><%=school2.getExpenses() %></td>
</tr>
<tr>
<td>PERCENT FINANCIAL AID</td>
<td><%=school2.getPerFinancial() %></td>
</tr>
<tr>
<td>NUMBER OF APPLICANTS</td>
<td><%=school2.getNumApplicants()%></td>
</tr>
<tr>
<td>PERCENT ADMITTED</td>
<td><%=school2.getPerAdmitted() %></td>
</tr>
<tr>
<td>PERCENT ENROLLED</td>
<td><%=school2.getPerEnrolled() %></td>
</tr>
<tr>
<td>ACADEMICS SCALE (1-5)</td>
<td><%=school2.getAcadScale() %></td>
</tr>
<tr>
<td>SOCIAL SCALE (1-5)</td>
<td><%=school2.getSocialScale() %></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE (1-5)</td>
<td><%=school2.getQOLScale() %></td>
</tr>
<tr>
<td>EMPHASES</td>
<td>
<%String[] emphases2 = school2.getEmphasis();
for(int i = 0; i < emphases2.length; i++){
	if(emphases2[i]!=null)
	out.println(emphases2[i]+"<br>");
 } %>
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