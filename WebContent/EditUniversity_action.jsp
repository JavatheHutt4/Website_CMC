<%@include file="VerifyAdmin.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
	AdminHome ah = new AdminHome();
	String school = request.getParameter("school");
	ah.editUniversity(school, request.getParameter("state"), request.getParameter("location"), request.getParameter("control"), 
			Integer.parseInt(request.getParameter("numStudents")), Double.parseDouble(request.getParameter("perFemale")), Double.parseDouble(request.getParameter("satVerbal")), 
			Double.parseDouble(request.getParameter("satMath")), Double.parseDouble(request.getParameter("expenses")), Double.parseDouble(request.getParameter("perFinancial")), 
			Integer.parseInt(request.getParameter("numApplicants")), Double.parseDouble(request.getParameter("perAdmitted")), Double.parseDouble(request.getParameter("perEnrolled")), 
			Integer.parseInt(request.getParameter("acadScale")), Integer.parseInt(request.getParameter("socialScale")), Integer.parseInt(request.getParameter("qolScale")));
	ah.deleteUniversityEmphases(school);
	ah.addUniversityEmphasis(school, request.getParameter("emphasis1"));
	ah.addUniversityEmphasis(school, request.getParameter("emphasis2"));
	ah.addUniversityEmphasis(school, request.getParameter("emphasis3"));
	ah.addUniversityEmphasis(school, request.getParameter("emphasis4"));
	ah.addUniversityEmphasis(school, request.getParameter("emphasis5"));
	response.sendRedirect("ManageUniversities.jsp?Error=-1");
%>
