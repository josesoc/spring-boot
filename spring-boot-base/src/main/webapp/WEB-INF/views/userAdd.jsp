<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="content">
	<legend>User Data</legend>
	<form:form action="/userAdd" modelAttribute="user">
		<label for="nameInput">Name: </label>
		<form:input path="name" id="nameInput"/>
		<form:errors path="name" cssClass="error" />		

		<label for="emailInput">Email: </label>
		<form:input path="email" id="emailInput" />
		<form:errors path="email" cssClass="error" />

		<label for="passwordInput">Password: </label>
		<form:input path="password" id="passwordInput" type="password" />
		<form:errors path="password" cssClass="error" />

		<br />
		<input type="submit" value="Submit" class="btn" />
	</form:form>

	<div class="info">
		<c:if test="${not empty message}">
			${message}
		</c:if>
	</div>
	<script >		
		 $(document).ready(function () {
		 	$('input').focus(function () { 
		 		$( ".info" ).empty(); 
		 	});
		 });
	</script>
</div>

