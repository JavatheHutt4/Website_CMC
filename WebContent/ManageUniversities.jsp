<%@include file="VerifyAdmin.jsp"%>>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Manage Universities</title>
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
<p id="panel" style="text-align: center;">
<a href="AdminMenu.jsp">
<img style="width: 64px; height: 64px; font-family: Draft Beer;"alt="CMCLogo" src="img/CMCLogo.png" align="left">
</a>
<font size="+3">Manage
Universities <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<p style ="text-align: center;">
<% String errorParam = request.getParameter("Error");
if (errorParam != null){
	int error = Integer.parseInt(errorParam);
	if (error == -1){
		out.println("University Edited Successfully.<br>");
	}
	if (error == -2){
		out.println("University Added Successfully.<br>");
	}
}
%>
</p>
<table style="text-align: left; background-color: silver; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">
<td colspan="17" rowspan="1" style="vertical-align: top;"><a
href="AddUniversity.jsp">Add a new University</a><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">School<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">State<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">Location<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">Control<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;"># of Students<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">% Female<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">SAT Verbal<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">SAT Math<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">Expenses<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">% with Financial Aid<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;"># of Applicants<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">% Admitted<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">% Enrolled<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">Academics Scale (1-5)<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">Social Scale (1-5)<br>
</td>
<td style="vertical-align: top; color: black; text-align: center;">Quality of Life Scale (1-5)<br>
</td>
<td style="vertical-align: top;"><br>
</td>
</tr>
<%
	SchoolHome sh = new SchoolHome();
	String[][] schools = sh.getAllUniversities();
	for(int i=0;i<schools.length;i++){
		School s = sh.findByName(schools[i][0]);
%>
<tr>
<td style="vertical-align: top; color: black;"><br><%=s.getName()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getState()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getLocation()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getControl()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getNumStudents()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getPerFemale()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getSatVerbal()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getSatMath()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getExpenses()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getPerFinancial()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getNumApplicants()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getPerAdmitted()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getPerEnrolled()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getAcadScale()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getSocialScale()%>
</td>
<td style="vertical-align: top; color: black;"><br><%=s.getQOLScale()%>
</td>
<td style="vertical-align: top;">
<form method="post" action="EditUniversity.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit"><br>
    <input name="School" value="<%=schools[i][0]%>" type="hidden">
</form>
<br>
</td>
</tr>
<%}%>
</tbody>
</table>
<br>
</body>
</html>


