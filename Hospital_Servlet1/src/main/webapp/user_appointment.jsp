<%@ page import="com.org.dao.DoctorDao" %>
<%@ page import="com.org.entity.Doctor" %>
<%@ page import="com.org.entity.User" %> <!-- Import your User class -->
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
    // Prevent caching of sensitive data in forms
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.

    // Retrieve userObj from session
    User userObj = (User) session.getAttribute("userObj"); // Assuming 'userObj' is stored in session

    // Debugging the userObj values
    if (userObj != null) {
        System.out.println("Debugging userObj:");
        System.out.println("Full Name: " + userObj.getFullname());
        System.out.println("Gender: " + userObj.getGender());
        System.out.println("Age: " + userObj.getAge());
        System.out.println("Phone Number: " + userObj.getPhno());
        System.out.println("Email: " + userObj.getEmail());
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Appointment</title>
    <%@ include file="component/allcss.jsp" %>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
        }
        .backImg {
            background: url("img/banner3.jpg");
            height: 50vh;
            width: 100%;
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <%@ include file="component/navbar.jsp" %>

    <div class="container mt-3">
        <c:if test="${not empty sessionScope.succMsg}">
            <div class="alert alert-success">${sessionScope.succMsg}</div>
            <c:remove var="succMsg" scope="session"/>
        </c:if>
        <c:if test="${not empty sessionScope.errorMsg}">
            <div class="alert alert-danger">${sessionScope.errorMsg}</div>
            <c:remove var="errorMsg" scope="session"/>
        </c:if>
    </div>

    <div class="container p-3 m-auto">
        <div class="row">
            <div class="col-md-8 m-auto">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="text-center fs-3 underline">User Appointment</p>

                        <form class="row g-3" action="appAppointment" method="post">
                            <input type="hidden" name="userid" value="${userObj.id}">

                            <div class="col-md-6">
                                <label for="fullname" class="form-label">Full Name</label>
                                <input required type="text" class="form-control" name="fullname" value="${userObj.fullname != null ? userObj.fullname : ''}">
                            </div>

                            <div class="col-md-6">
                                <label for="gender" class="form-label">Gender</label>
                                <select class="form-control" name="gender" required>
                                    <option value="male" <c:if test="${fn:toLowerCase(userObj.phno) == 'male'}">selected</c:if>>Male</option>
                                    <option value="female" <c:if test="${fn:toLowerCase(userObj.phno) == 'female'}">selected</c:if>>Female</option>
                                </select>
                            </div>

                            <div class="col-md-6">
                                <label for="age" class="form-label">Age</label>
                                <input required type="number" class="form-control" name="age" value="${userObj.age != null ? userObj.age : ''}">
                            </div>

                            <div class="col-md-6">
                                <label for="appoint_date" class="form-label">Appointment Date</label>
                                <input type="date" class="form-control" required name="appoint_date">
                            </div>

                            <div class="col-md-6">
                                <label for="phno" class="form-label">Phone No</label>
                                <input maxlength="15" required type="text" class="form-control" name="phno" value="${userObj.gender != null ? userObj.gender : ''}">
                            </div>

                            <div class="col-md-6">
                                <label for="diseases" class="form-label">Disease</label>
                                <input required type="text" class="form-control" name="diseases">
                            </div>

                            <div class="col-md-6">
                                <label for="email" class="form-label">Email</label>
                                <input required type="email" class="form-control" name="email" value="${userObj.email != null ? userObj.email : ''}">
                            </div>

                            <div class="col-md-6">
                                <label for="doct" class="form-label">Doctor</label>
                                <select required class="form-control" name="doct">
                                    <option value="">--select--</option>
                                    <% 
                                    DoctorDao dao = new DoctorDao();
                                    List<Doctor> list = dao.getAllDoctors();
                                    if (list != null && !list.isEmpty()) {
                                        for (Doctor d : list) {
                                    %>
                                    <option value="<%=d.getId()%>"><%=d.getFullName()%> (<%=d.getSpecialist()%>)</option>
                                    <%
                                        }
                                    } else {
                                    %>
                                    <option disabled>No doctors available</option>
                                    <%
                                    }
                                    %>
                                </select>
                            </div>

                            <c:if test="${empty userObj}">
                                <a href="user_login.jsp" class="col-md-6 btn btn-danger m-auto mt-3">Login Here!</a>
                            </c:if>
                            <c:if test="${not empty userObj}">
                                <button type="submit" class="col-md-6 offset-md-3 btn btn-success">Submit</button>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="component/footer.jsp" %>
</body>
</html>
