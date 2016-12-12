<!--Particular student ID details are displayed by it  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="Main.*"%>
     <%@ page import="beans.*"%>
    <%@page import=" java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body bgcolor="violet">
<div align="center">
<h2>Here are the details for the id which you have selected: </h2></div>
<table align="center" border="1">
<tr>
<td><b style="color: blue;">Name</b>:${ studentdetails.getName()}</td> 
<td><b style="color: blue;">Id</b>: ${ studentdetails.getId()}</td>
<td><b style="color: blue;">Address</b>: ${ studentdetails.getAddress()}</td>
</tr>

<tr>
<td><b style="color: blue;">Zip Code</b>: ${ studentdetails.getZip() }</td>
<td><b style="color: blue;">City</b>: ${ studentdetails.getCity() }</td>
<td><b style="color: blue;">State</b>: ${ studentdetails.getState()}</td>
</tr>


<tr>
<td><b style="color: blue;">Telephone</b>: ${ studentdetails.getPhone()}</td>
<td><b style="color: blue;">Email</b>: ${ studentdetails.getEmail()}</td>
<td><b style="color: blue;">URL</b>: ${ studentdetails.getUrl()}</td>
</tr>

<tr>
<td><b style="color: blue;">Date of Survey</b>: ${ studentdetails.getDate()}</td>
<td><b style="color: blue;">Liked about campus</b>: ${studentdetails.getCamp()}</td>
<td><b style="color: blue;">University Interest</b>: ${studentdetails.getUniversity()}</td>
</tr>

<tr>
<td><b style="color: blue;">Comments</b>: ${studentdetails.getComment()}</td>
<td><b style="color: blue;">Grad month</b>: ${studentdetails.getMonth()}</td>
<td><b style="color: blue;">Grad year</b>: ${studentdetails.getYear()}</td>
</tr>

<tr>
<td><b style="color: blue;">Recommendation</b>: ${studentdetails.getRecommend()}</td>
</tr>
</table>

</body>
</html>