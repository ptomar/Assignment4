<!-- If mean is more than 90 this page is displayed -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" java.util.*"%>
    <%@ page import="Main.*"%>
     <%@ page import="beans.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WinnerAknowledgement</title>
</head>
<body bgcolor="violet">
<div align="center">
<h1>Thank you very much for your time in providing this valuable survey !!</h1>
<h2 style="color: blue">Congratulations!!! You won two movie tickets!!!!!!</h2>
		<h3>The Mean for the values you entered is: <span style="color:red">${bean1.getMean() }</span></h3>
		<h3>The Standard Deviation is: <span style="color:red">${bean1.getstDev() }</span></h3>
		<p> Your Data has been saved successfully</p><br/>
<h4>Here is the list of id's which we have in our database. Please click on any and see the details fo that student:</h4>

	</div>	
		
	<table align="center">
	<ul>
		<%
		String[] idstring = (String[])request.getAttribute("JId");
		
		
			for (int i=0;i<idstring.length;i++) {
			String stuid = idstring[i];
		%>		
		<tr><td><li><a href="/CSGMU_SurveyForm/Servlet1?id=<%=stuid%>"><%=stuid%></a></li>	</td></tr>
		<%
			}
		%>
	</ul></table>
		

</body>
</html>