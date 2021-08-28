<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVD DEMO - LUV2CODE</title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		<br><br>
		Last name: <form:input path="lastName" />
		<br><br>
		
		
		<form:select path="country">
			
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br><br>
		
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		JS <form:radiobutton path="favoriteLanguage" value="Javascript" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		
		<br /><br />
		
		Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		MacOS <form:checkbox path="operatingSystems" value="MacOS" />
		Windows <form:checkbox path="operatingSystems" value="Window" />
		<br><br>
		
		<input type="submit" value="Submit" />
		
		
	</form:form>

</body>
</html>