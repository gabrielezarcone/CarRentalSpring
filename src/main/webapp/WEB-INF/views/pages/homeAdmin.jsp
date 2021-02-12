<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="table-responsive"> <%-- Per rendere responsive la tabella--%>
    <table id="allUsersTable">
        <thead>
            <tr>
                <th scope="col">Username</th>
                <th scope="col">Nome</th>
                <th scope="col">Cognome</th>
                <th scope="col">Data di nascita</th>
                <th scope="col">Stato</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${userList}">
                <tr class='${user.deleted ? "table-active" : ""}'>
                    <th scope="row">${user.username}</th>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td> <fmt:formatDate value="${user.birthDate}" type="date" /></td>
                    <c:choose>
                    <c:when test="${user.deleted eq false}">
                        <td>Attivo</td>
                        <td>
                            <a href='<c:url value="/admin/modifica?userid=${user.id}"/>' class="btn btn-success">Modifica</a>
                            <button  class="btn btn-danger" onclick="disabilita('${user.username}');">Elimina</button>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>Disabilitato</td>
                        <td></td>
                    </c:otherwise>
                    </c:choose>
            </c:forEach>
        </tbody>
    </table>
</div>