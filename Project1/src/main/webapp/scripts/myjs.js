/**
 * 
 */

window.onload = function() {
	clearBox();
	document.getElementById("homeDiv").style.display = "block";
	sendAjaxGet("http://localhost:8083/Project1/ShowProfileServlet", getEmpProfile);
	sendAjaxGet("http://localhost:8083/Project1/ShowReimServlet", getAllReimbursements);
	sendAjaxGet("http://localhost:8083/Project1/PReimServlet", getPendingReim);
	sendAjaxGet("http://localhost:8083/Project1/AReimServlet", getApprovedReim);
	sendAjaxGet("http://localhost:8083/Project1/DReimServlet", getDeniedReim);
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

$("#logoutButton").click(function(){
  $.ajax({ 
    url: "LogoutServlet"
  });
});

/* dont delete please
 * 
$(document).on("click", "#viewReimButton", function() {
	clearBox();
	$.get("ShowReimServlet", function(responseJson) {

		var $ul = $("<ul>").appendTo($("#somediv"));
		$.each(responseJson, function(index, item) {

			$("<li>").text(item).appendTo($ul);

		});
	});
});
*/

$(document).on("click", "#subReimButton", function() {
	clearBox();
	let x = document.getElementById("subReimDiv");
	if (x.style.display === "none") {
		x.style.display = "block";
	}
});

$(document).on("click", "#homeButton", function() {
	clearBox();
	let x = document.getElementById("homeDiv");
	if (x.style.display === "none") {
		x.style.display = "block";
	}
});

$(document).on("click", "#viewReimButton", function() {
	clearBox();
	let x = document.getElementById("showReimList");
	if (x.style.display === "none") {
		x.style.display = "block";
	}
});

function reimLister(reimStr){
	$("#reimUl").append("<li>" + reimStr + " <a href='javascript:void(0);' class='remove'>&times;</a></li>");
    $(document).on("click", "a.remove" , function() {
        $(this).parent().remove();
    });
};


/*
$(document).ready(function(){
    $("button").click(function(){
        $("ol").append("<li>list item <a href='javascript:void(0);' class='remove'>&times;</a></li>"); 
    });
    $(document).on("click", "a.remove" , function() {
        $(this).parent().remove();
    });
});
*/


/*
$(document).ready(function(){
    $("button").click(function(){
        $("ol").append("<li>list item <a href='javascript:void(0);' class='remove'>&times;</a></li>"); 
    });
    $(document).on("click", "a.remove" , function() {
        $(this).parent().remove();
    });
});
*/

function clearBox() {
	
	document.getElementById("showReimList").style.display = "none";
	document.getElementById("employeeButton").style.display = "none";
	document.getElementById("empProfileDiv").style.display = "none";
	document.getElementById("subReimDiv").style.display = "none";
	document.getElementById("homeDiv").style.display = "none";
	document.getElementById("empHeader").style.display="none"; // Hide the emp header

}