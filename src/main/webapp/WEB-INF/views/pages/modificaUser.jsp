<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Modifica user <strong>${user.username}</strong></h1>

<form:form method="post" modelAttribute="user">
    <form:input path="username"/>
    <form:input path="name"/>
    <form:input path="surname"/>
    <form:input path="password" type="password"/>
    <fmt:formatDate value="${user.birthDate}" pattern="yyyy-MM-dd" var="formatBirthDate"/>
    <form:input path="birthDate" type="date" value='${formatBirthDate}'/>
    <form:checkboxes path="ruoli" items="${roleList}"/>
    <input type="submit" value="Salva">
</form:form>