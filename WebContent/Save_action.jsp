<%@include file="VerifyUser.jsp"%>
<%@page language="java" import="CMCPackage.*,java.util.*"%>
<%String school = request.getParameter("SchoolName");
String username = lc.getMember().getUserName();
DatabaseController db = new DatabaseController();
int result = db.saveSchool(username,school);
	if(result==1){
		response.sendRedirect("ManageSchools.jsp?msg=2");
	}
	else
		response.sendRedirect("ManageSchools.jsp?msg=3");
%>