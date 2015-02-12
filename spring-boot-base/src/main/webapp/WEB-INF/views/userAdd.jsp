<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="content">
	<legend><spring:message code="userAdd.legend"/></legend>
	<form:form action="/userAdd" modelAttribute="user">
		<label for="nameInput"><spring:message code="userAdd.form.name"/>: </label>
		<form:input path="name" id="nameInput"/>
		<form:errors path="name" cssClass="error" />		

		<label for="emailInput">Email: </label>
		<form:input path="email" id="emailInput" />
		<form:errors path="email" cssClass="error" />

		<label for="passwordInput"><spring:message code="userAdd.form.password"/>: </label>
		<form:input path="password" id="passwordInput" type="password" />
		<form:errors path="password" cssClass="error" />
		
		<label for="roleInput"><spring:message code="userAdd.form.role"/>: </label>
		<form:select path="role" id="roleInput" class="selectpicker">
			<c:forEach items="${roles}" var="role">
				<option value="${role.id}"><c:out value="${role.name}" /></option>						
			</c:forEach>
		</form:select>	

		<br />
		<input type="submit" value='<spring:message code="userAdd.form.submit"/>' class="btn" />
	</form:form>

	<div class="info">
		<c:if test="${not empty message}">
			${message}
		</c:if>
	</div>
	<script>		
		 $(document).ready(function () {		
		 	$('input').focus(function () { 
		 		$( ".info" ).empty(); 
		 	});
		 });		
	</script>
</div>

