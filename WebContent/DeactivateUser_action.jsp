<%@include file="VerifyAdmin.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
AdminUI aui = new AdminUI();
String username = request.getParameter("User");
aui.deactivateMember(aui.findByName(username));

response.sendRedirect("ManageUsers.jsp?msg=2");
%>