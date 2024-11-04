<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Hospital Login</title>
    <%@ include file="component/allcss.jsp"%>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <style type="text/css">
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        main {
            flex: 1;
            padding: 20px 0;
        }
        .hospital-name {
            font-size: 2.5rem;
            color: #007BFF;
            font-weight: bold;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
            margin-bottom: 20px;
        }
        .tagline {
            font-size: 1.5rem;
            color: #6c757d;
            margin-bottom: 30px;
        }
        .card {
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <%@ include file="component/navbar.jsp"%>

    <main class="container mt-5">
        <div class="text-center">
            <span class="hospital-name">MX CARE</span>
            <h2 class="tagline">Your Health, Our Commitment</h2>

            <!-- Conditional Rendering -->
            <c:if test="${not empty userObj}">
                <h1 class="bold">Welcome, ${userObj.fullname}!</h1>
            </c:if>
            <c:if test="${empty userObj}">
                <h1 class="bold">To Get Started, Please Log In</h1>
            </c:if>
        </div>

        <c:if test="${empty userObj}">
            <div class="row justify-content-center mt-4">
                <!-- Admin Block -->
                <div class="col-md-4 mb-3">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Admin Login</h5>
                            <a href="admin_login.jsp" class="btn btn-primary btn-block">
                                <i class="fas fa-sign-in-alt"></i> Admin
                            </a>
                        </div>
                    </div>
                </div>

                <!-- Doctor Block -->
                <div class="col-md-4 mb-3">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">Doctor Login</h5>
                            <a href="doctor_login.jsp" class="btn btn-success btn-block">
                                <i class="fas fa-user-md"></i> Doctor
                            </a>
                        </div>
                    </div>
                </div>

                <!-- User Block -->
                <div class="col-md-4 mb-3">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title">User Login</h5>
                            <a href="user_login.jsp" class="btn btn-info btn-block">
                                <i class="fas fa-user"></i> User
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </main>

    <footer>
        <p>&copy; 2024 MX CARE. All Rights Reserved.</p>
    </footer>

    <%@ include file="component/footer.jsp" %>
</body>
</html>
