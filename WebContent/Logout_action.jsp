<% //LogonController lc = (LogonController) session.getAttribute("lc",lc);
session.setAttribute("lc", null);
response.sendRedirect("Login.jsp?Error=-1");
%>
