<%@page import="com.org.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Users</title>
    <%@include file="../component/allcss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
        .backImg {
            background: url("../img/banner.jpg");
            height: 50vh;
            width: 100%;
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container-fluid p-3">
        <div class="row">
            <div class="col-md-12">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-3 text-center">User Details</p>
                        <c:if test="${not empty errorMsg}">
                            <p class="fs-3 text-center text-danger">${errorMsg}</p>
                            <c:remove var="errorMsg" scope="session" />
                        </c:if>
                        <c:if test="${not empty succMsg}">
                            <div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
                            <c:remove var="succMsg" scope="session" />
                        </c:if>

                        <!-- Fetch all users from the database -->
                        <%
                            UserDao userDao = new UserDao();
                            List<User> users = userDao.getAllUsers();
                        %>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Full Name</th>
                                    <th>Email</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Phone Number</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                // Check if users list is not empty
                                if (users != null && !users.isEmpty()) { 
                                    for (User user : users) {
                                %>
                                <tr>
                                    <td><%= user.getId() %></td>
                                    <td><%= user.getFullname() %></td>
                                    <td><%= user.getEmail() %></td>
                                    <td><%= user.getAge() %></td>
                                    <td><%= user.getGender() %></td>
                                    <td><%= user.getPhno() %></td>
                                </tr>
                                <%
                                    }
                                } else { 
                                %>
                                <tr>
                                    <td colspan="6" class="text-center">No users found.</td>
                                </tr>
                                <%
                                } 
                                %>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
