/**
 * 
 */

window.onload = function() {
	clearBox();
	var $header = $("<h1>Welcome to the ERS.</h1>").appendTo($("#somediv"));
	
}

$(document).on("click", "#profileButton", function() {
	clearBox();
	let x = document.getElementById("empProfileDiv");
	if (x.style.display === "none") {
		x.style.display = "block";
	}
	$.get("ShowProfileServlet", function(responseJson) {
		var $ul = $("<ul>").appendTo($("#somediv"));
		$.each(responseJson, function(index, item) {
			$("<li>").text(item).appendTo($ul);
		});
	});
});

$(document).on("click", "#viewReimButton", function() {
	clearBox();
	$.get("ShowReimServlet", function(responseJson) {

		var $ul = $("<ul>").appendTo($("#somediv"));
		$.each(responseJson, function(index, item) {

			$("<li>").text(item).appendTo($ul);

		});
	});
});

$(document).on("click", "#subReimButton", function() {
	clearBox();
	let x = document.getElementById("subReimDiv");
	if (x.style.display === "none") {
		x.style.display = "block";
	}
});

function clearBox() {
	
	document.getElementById("empProfileDiv").style.display = "none";
	document.getElementById("subReimDiv").style.display = "none";
	document.getElementById("somediv").innerHTML = "";

}