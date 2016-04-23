<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
 LogonController lc = (LogonController) session.getAttribute("lc");
 if ((lc == null) || (lc.getMember() == null)){
     response.sendRedirect("Login.jsp?Error=-2");
     return;
 }
 if ((lc.getMember().getType() != 'a')){
	 	if (lc.getMember().getType() == 'u')
	 		response.sendRedirect("UserMenu.jsp?Error=-1");
	 	else 
	 		response.sendRedirect("Login.jsp?Error=-2");
	    return;
}
%>