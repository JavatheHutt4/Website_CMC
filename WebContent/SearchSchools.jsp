<%-- <%@include file="VerifyUser.jsp"%> --%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Search Schools</title>
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
<p id="panel" style="text-align: center;">

<a href="UserMenu.jsp">
<img style="width: 64px; height: 64px; font-family: Draft Beer;"alt="CMCLogo" src="img/CMCLogo.png" align="left">
</a>
<font size="+3">SEARCH FOR SCHOOLS <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<div id="panel">
<% String errorParam = request.getParameter("Error");
if (errorParam != null){
	int error = Integer.parseInt(errorParam);
	if (error == 1){
		out.println("Search yielded no matching schools. Check to make sure that your parameters are valid.");
	}
}
%>
<form 
method="post" action="SearchResults.jsp"
name="SearchForSchools"> 
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"cellspacing="2">
<tbody>
<tr>
<td>by SCHOOL NAME</td>
<td>contains <input name="SchoolName" type="text"></td>
</tr>
<tr>
<td>by STATE</td>
<td>contains <input name="State" type="text"></td>
</tr>
<tr>
<td>by LOCATION</td>
<td>contains <input name="Location" type="text">(SUBURBAN, URBAN, SMALL-CITY, or -1 for UNKNOWN)</td>
</tr>
<tr>
<td>by CONTROL</td>
<td>contains <input name="Control" type="text">(PRIVATE, STATE, CITY, or -1 for UNKNOWN)</td>
</tr>
<tr>
<td>by NUMBER OF STUDENTS</td>
<td>between <input name="NumberOfStudentsLow" type="text" value="-1"> and <input name="NumberOfStudentsHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by % FEMALE</td>
<td>between <input name="PerFemaleLow" type="text" value="-1"> and <input name="PerFemaleHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by SAT VERBAL</td>
<td>between <input name="SATVerbalLow" type="text" value="-1"> and <input name="SATVerbalHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by SAT MATH</td>
<td>between <input name="SATMathLow" type="text" value="-1"> and <input name="SATMathHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by EXPENSES</td>
<td>between <input name="ExpensesLow" type="text" value="-1"> and <input name="ExpensesHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by % FINANCIAL AID</td>
<td>between <input name="PerFinancialLow" type="text" value="-1"> and <input name="PerFinancialHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by NUMBER OF APPLICANTS</td>
<td>between <input name="NumberOfAppsLow" type="text" value="-1"> and <input name="NumberOfAppsHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by % ADMITTED</td>
<td>between <input name="PerAdmittedLow" type="text" value="-1"> and <input name="PerAdmittedHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by % ENROLLED</td>
<td>between <input name="PerEnrolledLow" type="text" value="-1"> and <input name="PerEnrolledHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by ACADEMICS SCALE(1-5)</td>
<td>between <input name="AcadScaleLow" type="text" value="-1"> and <input name="AcadScaleHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by SOCIAL SCALE(1-5)</td>
<td>between <input name="SocialScaleLow" type="text" value="-1"> and <input name="SocialScaleHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by QUALITY OF LIFE SCALE(1-5)</td>
<td>between <input name="QOLScaleLow" type="text" value="-1"> and <input name="QOLScaleHigh" type="text" value="-1"></td>
</tr>
<tr>
<td>by EMPHASIS</td>
<td>contains either <br>
<input name="Emphasis1" type="text"><br>
<input name="Emphasis2" type="text"><br>
<input name="Emphasis3" type="text"><br>
<input name="Emphasis4" type="text"><br>
<input name="Emphasis5" type="text"><br>
</td>
</tr>
</tbody>
</table>

<input name="searchforschools"
value="Search For Schools" type="submit"></form>
<input name="resetsearchforschools"
value="Reset Form" type="reset">

</div>
</body>
</html>