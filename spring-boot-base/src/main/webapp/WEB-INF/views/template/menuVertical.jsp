<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="menu">
	<ul class="nav nav-list well">
		<li class="nav-header">
			<spring:url value="/" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}">home</a>
		</li>
		<li class="divider"></li>
		<li class="nav-header">
			<spring:url value="/users" var="usersURL" htmlEscape="true" />
			<a href="${usersURL}">users</a>
		</li>
		<li class="divider"></li>
		<li class="nav-header">
			<spring:url value="/userAdd" var="userAddURL" htmlEscape="true" />
			<a href="${userAddURL}">user add</a>
		</li>	
	</ul>
</div>
