<!DOCTYPE html>
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

<link rel="stylesheet" type="text/css" href="styles/style.css">



</head>
<body>
	<div class="box"><nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">ERS</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="home.html">Home
			</a>
			<!-- <a class="nav-item nav-link" href="#">Nutrition</a> -->
			<a class="nav-item nav-link active" href="profile.html">Profile</a><span
				class="sr-only">(current)</span>
			<!--<a class="nav-item nav-link disabled" href="#">Disabled</a>-->

			<!--<a class="nav-item nav-link active" href="CherryCoke.html">home</a>-->
			<a class="nav-item nav-link active" href="login.html">Logout</a>
		</div>
	</div>
</nav></div>

<h1>Here you can view, approve, or deny reimbursements.</h1>
<div id="demo">

<button type="button" onclick="loadDoc()">View Profile Information</button>
</div>

<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", "http://localhost:8083/Project1/profile", true);
  xhttp.send();
}
</script>

</body>
</html>
