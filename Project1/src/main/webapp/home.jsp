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
<script>
$(document).on("click", "#profileButton", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	clearBox("somediv");
    $.get("ShowProfileServlet", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $ul = $("<ul>").appendTo($("#somediv")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
            $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
        });
    });
});

$(document).on("click", "#reimButton", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	clearBox("somediv");
    $.get("ShowReimServlet", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $ul = $("<ul>").appendTo($("#somediv")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
            $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
        });
    });
});



$(document).on("click", "#homeButton", function() { 
	clearBox("somediv");
	var $header = $("<h1>Welcome to the ERS.</h1>").appendTo($("#somediv"));   
});

function clearBox(elementID)
{
    document.getElementById("somediv").innerHTML = "";
}

window.onload = function() {
	var $header = $("<h1>Welcome to the ERS.</h1>").appendTo($("#somediv"));
}

</script>
</head>
<body>
	<div class="btn-group" role="group" aria-label="Basic example">
		<button type="button" class="btn btn-secondary" id="homeButton">Home</button>
		<button type="button" class="btn btn-secondary" id="profileButton">Profile</button>
		<button type="button" class="btn btn-secondary" id="reimButton">Reimbursements</button>
		<button type="button" class="btn btn-secondary" id="logoutButton">Logout</button>
		<div id="headerdiv"><h3>Current User: </h3></div>
	</div>

	<div id="somediv"></div>
</body>
</html>