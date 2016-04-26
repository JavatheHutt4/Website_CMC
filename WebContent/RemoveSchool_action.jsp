<%@include file="VerifyUser.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>


<%
String school = request.getParameter("School");
User user = (User) lc.getMember();
user.removeSavedSchool(school);
response.sendRedirect("ManageSchools.jsp?msg=1");
%>