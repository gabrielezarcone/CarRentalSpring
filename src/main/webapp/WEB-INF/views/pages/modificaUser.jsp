<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Modifica user <strong>${user.username}</strong></h1>

<c:url var="actionUrl"  value="/admin/modifica" />
<form:form method="post" modelAttribute="user" action="${actionUrl}">
    <form:input path="id" type="hidden"/>
    <form:input path="username"/>
    <form:input path="name"/>
    <form:input path="surname"/>
    <form:input path="password" type="password"/>
    <fmt:formatDate value="${user.birthDate}" pattern="yyyy-MM-dd" var="formatBirthDate"/>
    <form:input path="birthDate" type="date" value='${formatBirthDate}'/>
    <form:checkboxes path="ruoli" items="${roleList}"/>
    <input type="submit" value="Salva">
</form:form>