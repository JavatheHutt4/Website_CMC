<%@include file="VerifyAdmin.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Add University</title>
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
alt="CMCLogo" src="img/CMCLogo.png" align="left"><font size="+3">Add A New University<input name="logout" value="Logout" type="submit"></font> </p>
</form>
<br>
<div id="panel2">
<form style="height: 301px;" method="post"
action="AddUniversity_action.jsp" name="AddUniversity">
<table style="text-align: left; background-color: white; width: 600px; margin-left: auto; margin-right: auto;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">School<br>
</td>
<td style="vertical-align: top; color: black;"><input name="school"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">State<br>
</td>
<td style="vertical-align: top; color: black;"><input name="state"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Location<br>
</td>
<td style="vertical-align: top; color: black;"><input name="location"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Control<br>
</td>
<td style="vertical-align: top; color: black;"><input name="control"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;"># of Students<br>
</td>
<td style="vertical-align: top; color: black;"><input name="numStudents"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">% Female<br>
</td>
<td style="vertical-align: top; color: black;"><input name="perFemale"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">SAT Verbal<br>
</td>
<td style="vertical-align: top; color: black;"><input name="satVerbal"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">SAT Math<br>
</td>
<td style="vertical-align: top; color: black;"><input name="satMath"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Expenses<br>
</td>
<td style="vertical-align: top; color: black;"><input name="expenses"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">% with Financial Aid<br>
</td>
<td style="vertical-align: top; color: black;"><input name="perFinancial"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;"># of Applicants<br>
</td>
<td style="vertical-align: top; color: black;"><input name="numApplicants"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">% Admitted<br>
</td>
<td style="vertical-align: top; color: black;"><input name="perAdmitted"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">% Enrolled<br>
</td>
<td style="vertical-align: top; color: black;"><input name="perEnrolled"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Academics Scale (1-5)<br>
</td>
<td style="vertical-align: top; color: black;"><input name="acadScale"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Social Scale (1-5)<br>
</td>
<td style="vertical-align: top; color: black;"><input name="socialScale"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Quality of Life Scale (1-5)<br>
</td>
<td style="vertical-align: top; color: black;"><input name="qolScale"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top; color: black; text-align: center;">Emphases<br>
</td>
<td style="vertical-align: top; color: black;"><input name="emphasis1"><br><input name="emphasis2"><br><input name="emphasis3"><br>
<input name="emphasis4"><br><input name="emphasis5"><br>
</td>
</tr>
</tbody>
</table>
<br>
<div style="text-align: center;">&nbsp; <input value="Add School"
name="submit" type="submit"> <input name="reset" value="Reset"
type="reset"><br>
<br>
</div>
</form>
</div>
</body>
</html>