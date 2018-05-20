<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="main.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="btn-group" role="group" aria-label="Basic example">
		<button type="button" class="btn btn-secondary" id="homeButton">Home</button>
		<button type="button" class="btn btn-secondary" id="profileButton">Profile</button>
		<button type="button" class="btn btn-secondary" id="viewReimButton">View
			Reimbursements</button>
		<button type="button" class="btn btn-secondary" id="subReimButton">Submit
			Reimbursement</button>
		<button type="button" class="btn btn-secondary" id="logoutButton">Logout</button>
		<div id="headerdiv"></div>
	</div>

	<div id="subReimDiv">

		<form class="box" action="Request" method="post"
			enctype="multipart/form-data">
			<fieldset>
				<h2 class=" section-heading mb-4 ">
					<span class="section-heading-upper ">Enter your
						Reimbursement Request Information</span>
				</h2>
				<div class="mb-3 ">
					<div class="col-md-6 ">
						<div class="form-group ">
							<label for="amount">What is the reimbursement amount?</label> <input
								type="number" step="0.01" name="amount " class="form-control ">
							<label for="description ">Write a short description about
								the request:</label> <input type="text" name="description "
								class="form-control "> <label for="image">Insert
								your receipt</label> <input type="file" name="image"
								class="form-control "> <label for="type">Categorize
								your reimbursement type:</label> <select name="type"
								class="form-control ">
								<option value="1">Transportation</option>
								<option value="2">Entertainment</option>
								<option value="3">Food</option>
								<option value="4">Supplies</option>
							</select>
						</div>
					</div>
				</div>
			</fieldset>
			<br>
			<div class="intro-button mx-auto ">
				<input id="badbutton" class="btn btn-primary btn-xl " type="submit"
					value="submit " style="float: left">
			</div>
		</form>
	</div>

	<div id="empProfileDiv">

		<table id="myList" class="table">
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<tr>
				<th id="Me1"></th>
				<th id="Me2"></th>
				<th id="Me3"></th>
				<th id="Me4"></th>
				<th id="Me5"></th>
				<th id="Me6"></th>
			</tr>
		</table>

		<div id="accordion">

			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse"
						data-parent="#accordion" href="#collapseOne"> Update Personal
						Information </a>
				</div>
				<div id="collapseOne" class="collapse">
					<div class="card-body">
						<form class="box" action="UpdateEmpServlet" method="post">
							<fieldset>
								<h2 class="section-heading mb-4">
									<span class="section-heading-upper">Enter your changes:</span>
								</h2>
								<div class="mb-3">
									<div class="col-md-6">
										<div class="form-group">
											<label for="usr">Username: </label> <input id="usr1"
												type="text" name="usr" class="form-control"> <label
												for="psw">Password: </label> <input id="psw1" type="text"
												name="psw" class="form-control"> <label for="fnm">First
												Name: </label> <input id="fnm1" type="text" name="fnm"
												class="form-control"> <label for="lnm">Last
												Name: </label> <input id="lnm1" type="text" name="lnm"
												class="form-control"> <label for="eml">Email:
											</label> <input id="eml1" type="text" name="eml" class="form-control">

										</div>
									</div>
								</div>
							</fieldset>
							<br>
							<div class="intro-button mx-auto">
								<input class="btn btn-primary btn-xl" type="submit"
									value="Submit">
							</div>
						</form>
					</div>
				</div>
			</div>


			<div id="somediv"></div>

			<script src="scripts/ajax.js"></script>
			<script src="scripts/myjs.js"></script>
</body>
</html>