<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


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
		
			<button type="button" class="btn btn-secondary" id="employeeButton">Employees</button>
		
		<form class="box" action="LogoutServlet" method="post">
		<input class="btn btn-primary btn-xl" type="submit" value="Logout" style="margin-left:0px">
            </form>
	</div>

	<div id="viewReimDiv">
	
	
	
	
	</div>


	<div id="subReimDiv">

		<form class="box" action="SubmitReimServlet" method="post">
		<!-- 	enctype="multipart/form-data">  -->
			<fieldset>
				<h2 class=" section-heading mb-4 ">
					<span class="section-heading-upper ">Enter your
						Reimbursement Request Information</span>
				</h2>
				<div class="mb-3 ">
					<div class="col-md-6 ">
						<div class="form-group ">
								<label for="reimAmount">Enter Reimbursement Amount: </label> 
								<input type="number" step="0.01" name="val" class="form-control">
								<label for="reimDesc">Write a short description about the request:</label> 
								<input type="text" name="des" class="form-control"> 
						        <label for="reimReceipt">Please provide hyperlink to a receipt: </label> 
								<input type="text" name="rec" class="form-control">
						</div>
					</div>
				</div>
			</fieldset>
			<br>
			<div class="intro-button mx-auto ">
				<input id="submitReimButton" class="btn btn-primary btn-xl " type="submit"
					value="Submit" style="float: left">
			</div>
		</form>
	</div>

	<div id="empProfileDiv">

		<div id="empHeader">

			<table id="myList" class="table">
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Password</th>
					<th>Is Manager</th>
					<th>Email</th>
				</tr>
				<tr>
					<th id="e1"></th>
					<th id="e2"></th>
					<th id="e3"></th>
					<th id="e4"></th>
					<th id="e5"></th>
					<th id="e6"></th>
					<th id="e7"></th>
				</tr>
			</table>
		</div>

		<div id="accordion">

			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse"
						data-parent="#accordion" href="#collapseZero"> Update Personal
						Information </a>
				</div>
				<div id="collapseZero" class="collapse">
					<div class="card-body">
						<form class="box" action="UpdateEmpServlet" method="post">
							<fieldset>
								<h2 class="section-heading mb-4">
									<span class="section-heading-upper">Enter your changes:</span>
								</h2>
								<div class="mb-3">
									<div class="col-md-6">
										<div class="form-group">
											<label for="uname">Username: </label> 
											<input id="un" type="text" name="unname" class="form-control"> 
											<label for="pword">Firstname: </label> 
											<input id="pw" type="text" name="fname" class="form-control"> 
											<label for="fname">Lastname: </label> 
											<input id="fn" type="text" name="lname" class="form-control">
											<label for="lname">Password: </label> 
											<input id="ln" type="text" name="pword" class="form-control"> 
											<label for="isman">Is Manager: </label> 
											<input id="ism" type="text" name="isman" class="form-control"> 
											<label for="email">Email: </label> 
											<input id="em" type="text" name="email" class="form-control">

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
		</div>
	</div>

	<div id="homeDiv">
		<h1>Welcome to the ERS!</h1>
	</div>
	
	<div id="showReimList">
	
	  <div id="accordion2">

        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                    Display Pending Reimbursements
                </a>
            </div>
            <div id="collapseOne" class="collapse">
                <div class="card-body">
                    <table id="pendingList" class="table">
                        <tr>
                            <th>ID</th>
                            <th>Description</th>
                            <th>Receipt</th>
                            <th>Status</th>
                            <th>Manager ID</th>
                            <th>Employee ID</th>
                            <th>Amount</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                    Display Denied Reimbursements
                </a>
            </div>
            <div id="collapseTwo" class="collapse">
                <div class="card-body">
                    <table id="deniedList" class="table">
                        <tr>
                            <th>ID</th>
                            <th>Description</th>
                            <th>Receipt</th>
                            <th>Status</th>
                            <th>Manager ID</th>
                            <th>Employee ID</th>
                            <th>Amount</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        
        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                    Display Approved Reimbursements
                </a>
            </div>
            <div id="collapseThree" class="collapse">
                <div class="card-body">
                    <table id="approvedList" class="table">
                        <tr>
                            <th>ID</th>
                            <th>Description</th>
                            <th>Receipt</th>
                            <th>Status</th>
                            <th>Manager ID</th>
                            <th>Employee ID</th>
                            <th>Amount</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                    Approve/Deny Reimbursements
                </a>
            </div>
            <div id="collapseFour" class="collapse">
                <div class="card-body">
                    <form class="box" action="ADReimbursement" method="post">
                        <fieldset>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Resolve Reimbursement Requests</span>
                            </h2>
                            <div class="mb-3">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="reimSelector">Enter Reimbursement ID</label>
                                        <input type="number" name="reimbursementId" class="form-control">
                                        <label for="selector">Approve/Deny:</label>
                                        <select name="approveDeny" class="form-control">
                                            <option value="1">Approve</option>
                                            <option value="2">Deny</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <br>
                        <div class="intro-button mx-auto">
                            <input class="btn btn-primary btn-xl" type="submit" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
                    Display Employees
                </a>
            </div>
            <div id="collapseFive" class="collapse">
                <div class="card-body">
                    <table id="employeeList" class="table">
                        <tr>
                            <th>ID</th>
                            <th>UserName</th>
                            <th>Password</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Is Manager</th>
                            <th>Email</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion2" href="#collapseSix">
                    Display Reimbursements For Employee
                </a>
            </div>
            <div id="collapseSix" class="collapse">
                <div class="card-body">
                    <form class="box"> <!-- ="ReimsForEmpServlet"-->
                        <fieldset>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Single Employee Requests </span>
                            </h2>
                            <div class="mb-3">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="employee_Id">Enter Employee ID</label>
                                        <input id="empReimsId" type="number" name="emp_id" class="form-control" onkeyup="getReimsForEmp()">
                                    </div>
                                </div>
                            </div>
                        </fieldset>

                    </form>
					<div id="empReimDiv">
                    <table id="empReimTable" class="table">
                    </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
    
    <div id="accordion3">

        <div class="card">
            <div class="card-header">
                <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion3" href="#collapseSeven">
                    Display My Reimbursements
                </a>
            </div>
            <div id="collapseSeven" class="collapse">
                <div class="card-body">
                    <table id="myReimList" class="table">
                        <tr>
                            <th>ID</th>
                            <th>Description</th>
                            <th>Receipt</th>
                            <th>Status</th>
                            <th>Manager ID</th>
                            <th>Employee ID</th>
                            <th>Amount</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        </div>
	
	
		<ul id="reimUl">
		
		</ul>
	
	</div>

	<script src="scripts/ajax.js"></script>
	<script src="scripts/myjs.js"></script>
</body>
</html>