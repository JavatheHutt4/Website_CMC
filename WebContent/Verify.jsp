<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
 LogonController lc = (LogonController) session.getAttribute("lc");
 if ((lc.getMember() == null)){
     response.sendRedirect("Login.jsp?Error=-4");
     return;
 }
%>