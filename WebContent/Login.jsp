<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Logon</title>
<style type="text/css">
#panel {
border-radius: 10px;
padding: 10px;
margin-right: 80px;
margin-left: 80px;
background-color: silver;
color: #0e0d0d;
font-size: xx-large;
}
body {
background-color: #020202;
color: #fdfdfd;
}

</style>
</head>
<body>
<br>
<div style="text-align: center;"><span style="font-family: Draft Beer;">&nbsp;
</span><span style="color: white; font-family: Draft Beer;"></span><span
style="font-family: Draft Beer;">&nbsp;</span><img
style="width: 83px; height: 83px; font-family: Draft Beer;"
alt="CMCLogo"
src="file:///Users/tomrichmond/Desktop/CMC%20Graphics/CMCLogo.png"><span
style="font-family: Draft Beer;">&nbsp;
</span><big style="font-family: Draft Beer;"><font size="+3"><big><big>Choose
My College<span style="font-family: Arial;">™</span></big></big></font></big><span
style="font-family: Draft Beer;">&nbsp;</span><big
style="font-family: Draft Beer;"><font size="+3"><big>
<big><span style="color: white;"></span></big></big></font></big></div>
<p id="panel" style="text-align: center;">Welcome to the "Choose My
College"™
System! <br>
Please enter your username
and
password:<br>
</p>
<div id="panel">
<form method="post" action="login.action" name="Logon">
<table
style="width: 333px; height: 66px; background-color: white; margin-left: auto; margin-right: auto;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;"><span
style="color: rgb(51, 51, 51);">Username:</span><br>
</td>
<td style="vertical-align: top; color: rgb(40, 40, 40);"><input
name="user"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;"><span
style="color: rgb(2, 2, 2);">Password:</span><br>
</td>
<td style="vertical-align: top; color: rgb(15, 15, 15);"><input
name="password" type="password"><br>
</td>
</tr>
</tbody>
</table>
<div style="text-align: center;">&nbsp; <input value="Log On"
name="submit" type="submit"> <input name="reset" value="Reset"
type="reset"><br>
</div>
</form>
</div>
</body>
</html>
