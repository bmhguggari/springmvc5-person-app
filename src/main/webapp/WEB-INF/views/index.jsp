<%@ include file="header.jsp" %>
<div><h3>Welcome to Person management application</h3></div>
<div>
	<c:if test="${successMessage != null}">
		<c:out value="${successMessage}"></c:out>
	</c:if>
</div>
<%@ include file="footer.jsp" %>