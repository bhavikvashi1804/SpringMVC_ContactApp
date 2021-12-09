<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Contact App</title>
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">

		<h1 class="text-primary">Contact App</h1>

		<hr>
		<h4>Add New Contact</h4>
		<hr>

		<form:form action="save-customer" modelAttribute="contact"
			method="POST">
			<!-- First Name -->
			<div class="form-group">
				<label for="First Name">First Name</label>
				<form:input type="text" class="form-control" id="firstname"
					path="firstName" placeholder="Enter your first name" />
			</div>
			<!-- Last Name -->
			<div class="form-group">
				<label for="Last Name">Last Name</label>
				<form:input type="text" class="form-control" id="lastname"
					path="lastName" placeholder="Enter your last name" />
			</div>
			<!-- Email ID  -->
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label>
				<form:input type="email" class="form-control" path="emailId"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					placeholder="Enter email" />
				<small id="emailHelp" class="form-text text-muted">We'll
					never share your email with anyone else.</small>
			</div>
			<!-- Phone No -->
			<div class="form-group">
				<label for="Last Name">Phone Number</label>
				<form:input type="number" class="form-control" id="phoneNo"
					path="phoneNo" placeholder="Enter the Phone Number" />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>


		<a href="./home" class="text-center">Back to List</a>

		<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/script.js"></script>

	</div>
</body>
</html>