<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

${adminUser}
<c:forEach var="user" items="${usersList}">
    <ul>
        <li>${user.username}</li>
    </ul>
</c:forEach>