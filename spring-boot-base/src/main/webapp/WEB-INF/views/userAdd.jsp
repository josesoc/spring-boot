<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>

	<div id="container2">

		<h2>Add User</h2>
		<c:if test="${not empty message}">
			<div class="message green">${message}</div>
		</c:if>

		<form:form action="/user/add" modelAttribute="user">

			<label for="nameInput">Name: </label>
			<form:input path="name" id="nameInput" />
			<form:errors path="name" cssClass="error" />
			<br />

			<label for="emailInput">Email: </label>
			<form:input path="email" id="emailInput" />
			<form:errors path="email" cssClass="error" />
			<br />
			
			<label for="passwordInput">Password: </label>
			<form:input path="password" id="passwordInput"/>
			<form:errors path="password" cssClass="error" />
			<br />
			
			<input type="submit" value="Submit" />
		</form:form>
	</div>

</body>
