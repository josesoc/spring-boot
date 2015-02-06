<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul>
 
	<li><spring:url value="/" var="homeUrl" htmlEscape="true" />
		<a href="${homeUrl}">home</a>
	</li>
	<li><spring:url value="/list" var="listURL" htmlEscape="true" />
		<a href="${listURL}">list</a>
	</li>

</ul>
