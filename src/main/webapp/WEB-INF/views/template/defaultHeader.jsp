<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbarHeader">
    <div class="container-fluid">
        <a href="#" class="navbar-brand">CarRental</a>
        <%---Togler responsive: ----------------------------------------%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <%---Elementi navbar: ----------------------------------------%>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="<c:url value='/' />">Home</a>
                <a class="nav-link" href="#">Parco Auto</a>
                <a class="nav-link" href="#">Profilo</a>
            </div>
        </div>
    </div>
</nav>