<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%  
    LogonController lc = new LogonController();
    int loginStatus = lc.logon(request.getParameter("username"), request.getParameter("password"));
    if (loginStatus<0){
        response.sendRedirect("Login.jsp?Error="+loginStatus);
    }
    else{
        session.setAttribute("lc", lc);
        if (loginStatus == 1)
        	response.sendRedirect("UserMenu.jsp");
        else if (loginStatus == 2)
        	response.sendRedirect("AdminMenu.jsp");
    }
%>