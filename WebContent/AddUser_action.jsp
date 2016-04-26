<%@include file="VerifyAdmin.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<% 
AdminUI aui = new AdminUI();
String first = request.getParameter("first");
String last = request.getParameter("last");
String username = request.getParameter("username");
String password = request.getParameter("password");
char type = request.getParameter("type").charAt(0);

int error = aui.addMember(first,last,username,password,type, 'Y');

if (error >=0)
	response.sendRedirect("ManageUsers.jsp");
else{
	response.sendRedirect("AddUser.jsp?Error="+error);
}
%>