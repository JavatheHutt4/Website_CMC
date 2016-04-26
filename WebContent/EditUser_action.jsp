<%@include file="VerifyAdmin.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<% 
AdminUI aui = new AdminUI();
String first = request.getParameter("first");
String last = request.getParameter("last");
String username = request.getParameter("username");
String password = request.getParameter("password");
char type = request.getParameter("type").charAt(0);
char status = request.getParameter("status").charAt(0);

if (type != 'a' || type != 'u'){
	response.sendRedirect("EditUser.jsp?Error=-1");
}
else if (status != 'Y' || status != 'N'){
	response.sendRedirect("EditUser.jsp?Error=-2");
}
aui.editMember(first,last,username,password,type, status);

response.sendRedirect("ManageUsers.jsp?msg=1");
%>