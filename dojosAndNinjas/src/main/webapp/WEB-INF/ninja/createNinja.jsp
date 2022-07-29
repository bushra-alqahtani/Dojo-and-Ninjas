<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>

	<div class="container m-5">


		<h1>Create New Ninja :</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja" >
		    <p>
		        <form:label path="firstName">fName :</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>
		    
		    
		       <p>
		        <form:label path="lastName">lName :</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>
		   
		    <p>
		        <form:label path="age">age :</form:label>
		        <form:errors path="age"/>
		        <form:input type="number"  path="age"/>
		    </p>
		    <p>
		        <form:label path="dojo">Select Dojo :</form:label>
		        <form:errors path="dojo"/>
		        <form:select path="dojo">
		        
		        <option >select</option>
		        <c:forEach var="i" items="${dojos}">
				        <option value="${i.id}"> 
				        		<c:out value="${i.name}"/> 
				        </option>
			        </c:forEach>
			        
			        
		        </form:select>
		    </p>
		   
		    <input type="submit" value="Submit"/>
		</form:form>



	</div>
</body>
</html>
