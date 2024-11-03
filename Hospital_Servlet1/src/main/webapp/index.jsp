<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Home</title>
<%@ include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<!-- CSS here -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/flaticon.css">
    <link rel="stylesheet" href="assets/css/gijgo.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
	<link rel="stylesheet" href="assets/css/magnific-popup.css">
	<link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
	<link rel="stylesheet" href="assets/css/themify-icons.css">
	<link rel="stylesheet" href="assets/css/slick.css">
	<link rel="stylesheet" href="assets/css/nice-select.css">
	<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<%@ include file="component/navbar.jsp"%>

	
	<main>
	<!--? department_area_start  -->
    
	<div class="container p-3">
		<p class="text-center fs-2 ">Key Features of our Hospital</p>

		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6 p-4">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">100% Safety</p>
								
							</div>
						</div>
					</div>
					<div class="col-md-6 p-4">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Clean Environment</p>
								
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2 p-4">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Friendly Doctors</p>
								
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2 p-4" >
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-3 p-4">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5"> 24 x 7 service</p>
								
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-3 p-4">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Advanced Equipment</p>
								
							</div>
						</div>
					</div>
				</div>
			</div>

			
		</div>
	</div>


<hr>
	
	<!--? Team Start -->
		<div class="team-area section-padding30">
			<div class="container">
				<!-- Section Tittle -->
				<div class="row justify-content-center">
					<div class="col-lg-6">
						<div class="section-tittle text-center mb-100">
							<span>Our Doctors</span>
							<h2>Our Specialist</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single Tem -->
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-">
						<div class="single-team mb-30">
						
							<div class="team-caption">
								<h3>
									<a href="#">Kartik Lakra</a>
								</h3>
								<span>Cardiologist</span>
								<!-- Team social -->
								
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-">
						<div class="single-team mb-30">
							
							<div class="team-caption">
								<h3>
									<a href="#">Hemonesh</a>
								</h3>
								<span>Dentist</span>
								<!-- Team social -->
								
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-">
						<div class="single-team mb-30">
							
							<div class="team-caption">
								<h3>
									<a href="#">Anshika</a>
								</h3>
								<span>Dermatologist</span>
								<!-- Team social -->
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    </main>

<%@ include file="component/footer.jsp" %>
</body>
</html>
