<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%
 LogonController lc = (LogonController) session.getAttribute("lc");
 if ((lc == null) || (lc.getMember() == null)){
     response.sendRedirect("Login.jsp?Error=-2");
     return;
 }
 if ((lc.getMember().getType() != 'u')){
	 	if (lc.getMember().getType() == 'a')
	 		response.sendRedirect("AdminMenu.jsp?Error=-1");
	 	else 
	 		response.sendRedirect("Login.jsp?Error=-2");
	    return;
}
%>