<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul>
 
	<li><spring:url value="/" var="homeUrl" htmlEscape="true" />
		<a href="${homeUrl}">home</a>
	</li>
	<li><spring:url value="/users" var="usersURL" htmlEscape="true" />
		<a href="${usersURL}">users</a>
	</li>
	
	<!--
	<li><spring:url value="/user/pepe@gmail.com" var="userURL" htmlEscape="true" />
		<a href="${userURL}">user</a>
	</li>
	-->
	
	<li><spring:url value="/user/add" var="userAddURL" htmlEscape="true" />
		<a href="${userAddURL}">user add</a>
	</li>

</ul>
