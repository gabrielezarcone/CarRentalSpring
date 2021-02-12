<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="homeChooser">
    <h3>A quale Homepage vuoi accedere?</h3>
    <a href="<c:url value="/admin/home"/>" class="chooseAdminBtn">Admin</a>
    <a href="<c:url value="/customer/home"/>" class="chooseCustomerBtn">Customer</a>
</div>