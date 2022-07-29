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
	
		<h1>Create New Dojo :</h1> 
		

		<form:form action="/dojos/new" method="post" modelAttribute="dojo">

			<div class="mb-3">
				<label class="form-label">name :</label> <input type="text"
					class="form-control" name="name">
				<form:errors path="name" class="text-danger" />
			</div>
		<input type="submit" value="Submit" />
		</form:form>
	</div>
	
	
	
	
	<div class="container m-5">
    <table  class="table table-striped table-hover ">
  <thead>
    <tr>
      <th scope="col">All dojos</th>  
    </tr>
  </thead>
  <tbody>
  <c:forEach  items="${dojos}" var="i">
	    <tr>
		      <td> <a href="/dojos/${i.id}"  ><c:out value = "${i.name}"/></a>  </td>     
	    </tr>
    </c:forEach>
		  </tbody>
		</table>
			<br>
	
			<a href="/ninjas/new"><button type="button" class="btn btn-secondary" > Create Ninjas  </button></a>
    
    		<br>
		
		
     </div>
</body>
</html>
