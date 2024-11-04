<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<%@ include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="component/navbar.jsp"%>

<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-4 text-center">User Register</p>

                    <c:if test="${not empty sucMsg}">
                        <p class="text-center text-success fs-3">${sucMsg}</p>
                        <c:remove var="sucMsg" scope="session" />
                    </c:if>

                    <c:if test="${not empty errorMsg}">
                        <p class="text-center text-danger fs-3">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>

                    <form action="user_register" method="post">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label> 
                            <input required name="fullname" type="text" class="form-control" value="${user.fullname}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email address</label> 
                            <input required name="email" type="email" class="form-control" value="${user.email}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label> 
                            <input required name="password" type="password" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Age</label> 
                            <input required name="age" type="number" class="form-control" value="${user.age}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Phone Number</label> 
                            <input required name="phno" type="text" class="form-control" maxlength="15" value="${user.phno}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Gender</label> 
                            <select required name="gender" class="form-control">
                                <option value="male" ${user.gender == 'male' ? 'selected' : ''}>Male</option>
                                <option value="female" ${user.gender == 'female' ? 'selected' : ''}>Female</option>
                                <option value="other" ${user.gender == 'other' ? 'selected' : ''}>Other</option>
                            </select>
                        </div>
                        <button type="submit" class="btn bg-success text-white col-md-12">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>