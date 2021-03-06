<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--  Import sort Utills -->
<%@ page import="com.bhavik.apps.contacts.util.SortUtils"%>
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
		<div class="btn btn-success"
			onclick="window.location.href='home'; return false;">Show All
			Contacts</div>
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
				<!-- Searching Functionality -->

				<div class="col">
					<form:form action="search" method="GET">
					Search Contact: <input type="text" name="theSearchName">
						<input type="submit" value="Search" class="btn btn-secondary">
					</form:form>
				</div>






				<!-- Create a sorting URLS -->
				<!-- construct a sort link for first name -->
				<c:url var="sortLinkId" value="/contacts/home">
					<c:if test="${searchKeyWord != null }">
						<c:param name="searchKeyword" value="${searchKeyWord}"></c:param>
					</c:if>
					<c:param name="sort" value="0" />
				</c:url>
				<c:url var="sortLinkFirstName" value="/contacts/home">
					<c:if test="${searchKeyWord != null }">
						<c:param name="searchKeyword" value="${searchKeyWord}"></c:param>
					</c:if>
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.FIRST_NAME)%>" />
				</c:url>
				<c:url var="sortLinkLastName" value="/contacts/home">
					<c:if test="${searchKeyWord != null }">
						<c:param name="searchKeyword" value="${searchKeyWord}"></c:param>
					</c:if>
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.LAST_NAME)%>" />
				</c:url>
				<c:url var="sortLinkEmailId" value="/contacts/home">
					<c:if test="${searchKeyWord != null }">
						<c:param name="searchKeyword" value="${searchKeyWord}"></c:param>
					</c:if>
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.EMAIL_ID)%>" />
				</c:url>


				<!--  List of Contacts -->
				<table class="table table-striped">
					<caption>Your Contacts are</caption>
					<thead>
						<tr>
							<th><a href="${sortLinkId}">#</a></th>
							<th><a href="${sortLinkFirstName}">First Name</a></th>
							<th><a href="${sortLinkLastName}">Last Name</a></th>
							<th><a href="${sortLinkEmailId}">Email ID</a></th>
							<th>Phone No</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="oneContact" items="${contactList}">

							<!-- Create a Link Var -->
							<c:url var="updateLink" value="/contacts/showUpdateContactForm">
								<c:param name="contactId" value="${oneContact.id}"></c:param>
							</c:url>
							<c:url var="deleteLink" value="/contacts/delete-contact">
								<c:param name="contactId" value="${oneContact.id}"></c:param>
							</c:url>


							<tr>
								<td>${oneContact.id}</td>
								<td>${oneContact.firstName}</td>
								<td>${oneContact.lastName}</td>
								<td>${oneContact.emailId}</td>
								<td>${oneContact.phoneNo}</td>
								<td><a href="${updateLink}">Update</a> / <a
									href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this contact?'))) return false">Delete</a></td>
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