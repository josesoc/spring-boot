<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<h3>Iterating over users</h3>
	<ul>
		<c:forEach items="${users}" var="user">
			<li><c:out value="${user.name}" /></li>
		</c:forEach>
	</ul>
</body>

