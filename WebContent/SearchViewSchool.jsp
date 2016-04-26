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
SearchController sc = new SearchController();
School school = sh.findByName(schoolName);
String[][] recommendedSchools = sc.getRecommendedSchools(school);
try {
    wait(65000);
} catch (InterruptedException e) {
    //Handle exception
}
%>
Information for <%=schoolName%>
<table style="text-align: center; width: 100%;" border="1" >
<tbody>
<tr>
<td>SCHOOL NAME</td>
<td><%=school.getName()%>
</td>
</tr>
<tr>
<td>bSTATE</td>
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
<td>ACADEMICS SCALE(1-5)</td>
<td><%=school.getAcadScale() %></td>
</tr>
<tr>
<td>SOCIAL SCALE(1-5)</td>
<td><%=school.getSocialScale() %></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE(1-5)</td>
<td><%=school.getQOLScale() %></td>
</tr>
<tr>
<td>EMPHASES</td>
<td>
<%String[] emphases = school.getEmphasis();
for(int i = 0; i < emphases.length; i++){
	out.print(emphases[i]);
%>
<br>
<% } %>
</td>
</tr>
<tr>
<td>
<form method="post" action="SearchSave_action.jsp" name="Save School">
<input name="saveSchool"
	value="Save" type="submit"><br>
    <input name="SchoolName" value="<%=schoolName %>" type="hidden"><br>
</form>
</tbody>
</table>
<br>
<br>
MAY WE ALSO RECOMMEND:
<%for(int j = 0; j < recommendedSchools.length; j++){ %>
<table style="text-align: center; width: 100%;" border="1" >
<tbody>
<tr>
<td>SCHOOL NAME</td>
<td><%=school.getName()%>
</td>
</tr>
<tr>
<td>bSTATE</td>
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
<td>ACADEMICS SCALE(1-5)</td>
<td><%=school.getAcadScale() %></td>
</tr>
<tr>
<td>SOCIAL SCALE(1-5)</td>
<td><%=school.getSocialScale() %></td>
</tr>
<tr>
<td>QUALITY OF LIFE SCALE(1-5)</td>
<td><%=school.getQOLScale() %></td>
</tr>
<tr>
<td>EMPHASES</td>
<td>
<%String[] emphases2 = school.getEmphasis();
for(int i = 0; i < emphases.length; i++){
	out.print(emphases2[i]);
%>
<br>
<% } %></td>
</tr>
<tr>
<td>
<form method="post" action="SearchSave_action.jsp" name="Save School">
<input name="saveSchool"
	value="Save" type="submit"><br>
    <input name="SchoolName" value="<%=recommendedSchools[j][0] %>" type="hidden"><br>
</form>
</tbody>
</table>
<br>
<% } %>
</div>
</body>
</html>