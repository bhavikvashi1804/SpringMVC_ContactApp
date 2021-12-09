<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<input type="button" class="btn btn-primary" value="Add Contact"
			onclick="window.location.href='showAddContactForm'; return false;" />
		<hr>
		<!-- check that data is present or not and display -->
		<c:choose>
			<c:when test="${contactList.size() == 0}">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title text-danger">No records found</h2>
						<p class="card-text text-info">Add some records by hitting Add
							Contact.</p>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<table class="table table-striped">
					<caption>Your Contacts are</caption>
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email ID</th>
							<th>Phone No</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="oneContact" items="${contactList}">
							<tr>
								<td>${oneContact.id}</td>
								<td>${oneContact.firstName}</td>
								<td>${oneContact.lastName}</td>
								<td>${oneContact.emailId}</td>
								<td>${oneContact.phoneNo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>



		<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/script.js"></script>

	</div>
</body>
</html>