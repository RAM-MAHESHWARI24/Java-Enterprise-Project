<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<style>
    .a {
        color: darkgreen;
    }
    .navbar {
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    .nav-link {
        transition: color 0.3s;
    }
    .nav-link:hover {
        color: darkgreen; /* Change link color on hover */
    }
    .dropdown-menu {
        background-color: #f8f9fa; /* Light background for dropdown */
    }
    .dropdown-item:hover {
        background-color: darkgreen; /* Highlight on hover */
        color: white; /* Text color on hover */
    }
    .message {
        padding: 15px;
        margin: 10px 0;
        border-radius: 5px;
        font-size: 16px;
    }
    .message-found {
        background-color: #d4edda; /* Light green background */
        color: #155724; /* Dark green text */
        border: 1px solid #c3e6cb; /* Green border */
    }
    .message-not-found {
        background-color: #f8d7da; /* Light red background */
        color: #721c24; /* Dark red text */
        border: 1px solid #f5c6cb; /* Red border */
    }
</style>

<nav class="navbar navbar-expand-lg bg-light text-dark">
    <div class="container-fluid">
        <div class="logo">
            <a href="index.jsp">
                <img src="assets/img/logo/logo.png" alt="Hospital Logo" class="img-fluid" style="max-height: 50px;">
            </a>
        </div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                <c:if test="${empty userObj}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="admin_login.jsp">
                            <i class="fas fa-sign-in-alt"></i> ADMIN
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="doctor_login.jsp">DOCTOR</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="user_login.jsp">USER</a>
                    </li>
                    
                </c:if>

                <c:if test="${not empty userObj}">
                    <li class="nav-item">
                        <a class="nav-link active" href="user_appointment.jsp">APPOINTMENT</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="view_appointment.jsp">VIEW APPOINTMENT</a>
                    </li>
                    <li class="nav-item dropdown">
                        <button class="btn btn-success dropdown-toggle" type="button"
                            id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa-solid fa-circle-user"></i> ${userObj.fullname}
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="userLogout">Logout</a></li>
                        </ul>
                    </li>
                    
                </c:if>

            </ul>
        </div>
    </div>
</nav>