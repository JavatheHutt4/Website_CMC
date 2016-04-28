<%@include file="VerifyUser.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
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
<img style="width: 64px; height: 64px; font-family: Draft Beer;" alt="CMCLogo" src="img/CMCLogo.png" align="left">
</a>
<font size="+3">SEARCH RESULTS <input name="logout" value="Logout" type="submit"></font> </p>
</form>
<div id="panel">
<table style="text-align: center; width: 100%;" border="1" cellpadding="2"
cellspacing="2" >
<% 

String schoolName = request.getParameter("SchoolName");
String state = request.getParameter("State");
String location = request.getParameter("Location");
String control = request.getParameter("Control");
int numberOfStudentsLow = Integer.parseInt(request.getParameter("NumberOfStudentsLow"));
int numberOfStudentsHigh = Integer.parseInt(request.getParameter("NumberOfStudentsHigh"));
double perFemaleLow = Double.parseDouble(request.getParameter("PerFemaleLow"));
double perFemaleHigh = Double.parseDouble(request.getParameter("PerFemaleHigh"));
double satVerbalLow = Double.parseDouble(request.getParameter("SATVerbalLow"));
double satVerbalHigh = Double.parseDouble(request.getParameter("SATVerbalHigh"));
double satMathLow = Double.parseDouble(request.getParameter("SATMathLow"));
double satMathHigh = Double.parseDouble(request.getParameter("SATMathHigh"));
double expensesLow = Double.parseDouble(request.getParameter("ExpensesLow"));
double expensesHigh = Double.parseDouble(request.getParameter("ExpensesHigh"));
double perFinancialLow = Double.parseDouble(request.getParameter("PerFinancialLow"));
double perFinancialHigh = Double.parseDouble(request.getParameter("PerFinancialHigh"));
int numberOfAppsLow = Integer.parseInt(request.getParameter("NumberOfAppsLow"));
int numberOfAppsHigh = Integer.parseInt(request.getParameter("NumberOfAppsHigh"));
double perAdmittedLow = Double.parseDouble(request.getParameter("PerAdmittedLow"));
double perAdmittedHigh = Double.parseDouble(request.getParameter("PerAdmittedHigh"));
double perEnrolledLow = Double.parseDouble(request.getParameter("PerEnrolledLow"));
double perEnrolledHigh = Double.parseDouble(request.getParameter("PerEnrolledHigh"));
int acadScaleLow = Integer.parseInt(request.getParameter("AcadScaleLow"));
int acadScaleHigh = Integer.parseInt(request.getParameter("AcadScaleHigh"));
int socialScaleLow = Integer.parseInt(request.getParameter("SocialScaleLow"));
int socialScaleHigh = Integer.parseInt(request.getParameter("SocialScaleHigh"));
int qOLScaleLow = Integer.parseInt(request.getParameter("QOLScaleLow"));
int qOLScaleHigh = Integer.parseInt(request.getParameter("QOLScaleHigh"));
String emphasis1 = request.getParameter("Emphasis1");
String emphasis2 = request.getParameter("Emphasis2");
String emphasis3 = request.getParameter("Emphasis3");
String emphasis4 = request.getParameter("Emphasis4");
String emphasis5 = request.getParameter("Emphasis5");

SchoolHome sh = new SchoolHome();
SearchController sc = new SearchController();
String[][] results = sc.search(schoolName,state,location,control,numberOfStudentsLow,numberOfStudentsHigh,
		perFemaleLow,perFemaleHigh,satVerbalLow,satVerbalHigh,satMathLow,satMathHigh,expensesLow,expensesHigh,
		perFinancialLow,perFinancialHigh,numberOfAppsLow,numberOfAppsHigh,perAdmittedLow,perAdmittedHigh,
		perEnrolledLow,perEnrolledHigh,acadScaleLow,acadScaleHigh,socialScaleLow,socialScaleHigh,qOLScaleLow,qOLScaleHigh,
		emphasis1,emphasis2,emphasis3,emphasis4,emphasis5);
String result = "FAIL"; 

if(result.equals(results[0][0])) 
	response.sendRedirect("SearchSchools.jsp?Error=1");

ArrayList<School> schools = new ArrayList<School>();
for(int i = 0; i < results.length; i++){
	schools.add(sh.findByName(results[i][0])); 
}

for(int i = 0; i < results.length; i++){
	if(!results[0][0].equals("FAIL")){
%>
<tbody>
<tr>
<td>
<form method="post" action="SearchViewSchool.jsp" name="SearchViewSchool">
    <input name="viewSchool"
	value="View" type="submit">
    <input name="SchoolName" value="<%=schools.get(i).getName() %>" type="hidden">
	</form>
</td>
<td><%=schools.get(i).getName() %></td>
<td>
	<form method="post" action="Save_action.jsp" name="SearchSave">
    <input name="saveSchool"
	value="Save" type="submit">
    <input name="SchoolName" value="<%=schools.get(i).getName() %>" type="hidden">
    </form>
    
</td> 
</tr>
<% }} %>
</tbody>
</table>


</div>
</body>
</html>