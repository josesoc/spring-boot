<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="content">
	<legend>Iterating over users</legend>
	<table
		class="table table-bordered table-striped table-hover table-condensed">
		<tr>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.email}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

