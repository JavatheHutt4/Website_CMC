<%@include file="Verify.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
	User user = (User) lc.getMember();
	UserHome uh = new UserHome(user);
	String first = request.getParameter("firstName");
	String last = request.getParameter("lastName");
	String password = request.getParameter("password");
	uh.editUserInfo(first, last, password);
	response.sendRedirect("UserMenu.jsp");
%>