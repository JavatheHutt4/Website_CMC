<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
 LogonController lc = (LogonController) session.getAttribute("lc");
 if ((lc == null) || (lc.getMember() == null)){
     response.sendRedirect("Login.jsp?Error=-2");
     return;
 }
%>