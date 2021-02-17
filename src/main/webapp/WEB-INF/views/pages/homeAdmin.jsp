<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="<c:url value="/admin/aggiungi"></c:url>" class="addUserBtn"><i class="bi-person-plus-fill"></i></a>
<div class="table-responsive"> <%-- Per rendere responsive la tabella--%>
    <table id="allUsersTable">
        <thead>
            <tr>
                <th scope="col">Username</th>
                <th scope="col">Nome</th>
                <th scope="col">Cognome</th>
                <th scope="col">Data di nascita</th>
                <th scope="col">Stato</th>
                <th scope="col">
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Cerca" aria-label="Search">
                        <select class="form-select me-2 w-50 bg-dark text-white" aria-label="Default select example">
                            <option selected value="username">Username</option>
                            <option value="nome">Nome</option>
                            <option value="cognome">Cognome</option>
                            <option value="birthDate">Data di nascita</option>
                            <option value="stato">Stato</option>
                        </select>
                        <button class="btn btn-outline-primary" type="submit">Search</button>
                    </form>
                </th>
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
                            <div class="btn-group w-100" role="group">
                                <a href='<c:url value="/admin/modifica?userid=${user.id}"/>' class="btn btn-success">Modifica</a>
                                <button  class="btn btn-danger" onclick="disabilita('${user.username}');">Elimina</button>
                                <a href='<c:url value="/admin/prenotazioni/${user.id}"/>' class="btn btn-primary">Prenotazioni</a>
                            </div>
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
    <c:forEach var="ruolo" items="${ruoliList}">
        ${ruolo.ruolo}
    </c:forEach>
</div>