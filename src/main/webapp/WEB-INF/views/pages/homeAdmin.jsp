<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="allUsersTable">
    <thead>
        <tr>
            <th scope="col">Username</th>
            <th scope="col">Nome</th>
            <th scope="col">Cognome</th>
            <th scope="col">Data di nascita</th>
            <th scope="col">Stato</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <th scope="row">${user.username}</th>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.birthDate}</td>
                <td>${user.deleted ? "Disabilitato" : "Attivo"}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>