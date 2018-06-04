/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("POST", url, true);
	xhr.send();
};

function getEmpProfile(xhr) {
	var Emp = xhr.responseText.split("Employee");
	var eachVal = Emp[1].split(":");

	document.getElementById("e1").textContent = eachVal[0];
	document.getElementById("e2").textContent = eachVal[1];
	document.getElementById("e3").textContent = eachVal[2];
	document.getElementById("e4").textContent = eachVal[3];
	document.getElementById("e5").textContent = eachVal[4];
	document.getElementById("e6").textContent = eachVal[5];
	document.getElementById("e7").textContent = eachVal[6];
	document.getElementById("un").value = eachVal[1];
	document.getElementById("fn").value = eachVal[3];
	document.getElementById("ln").value = eachVal[4];
	document.getElementById("pw").value = eachVal[2];
	document.getElementById("ism").value = eachVal[5];
	document.getElementById("em").value = eachVal[6];

	var man = document.getElementById("ism").value;
	if (man == 1) {
		sendAjaxGet("http://localhost:8083/Project1/PReimServlet", getPendingReim);
		sendAjaxGet("http://localhost:8083/Project1/AReimServlet", getApprovedReim);
		sendAjaxGet("http://localhost:8083/Project1/DReimServlet", getDeniedReim);
		sendAjaxGet("http://localhost:8083/Project1/GetEmployeesServlet", getEmployees);
		document.getElementById("accordion2").style.display = "block";
	} else {
		document.getElementById("accordion2").style.display = "none";
	}

}

/*
 * function getAllReimbursements(xhr) { var Reim =
 * xhr.responseText.split("Reimbursement");
 * 
 * for (let i = 0; i < Reim.length; i++) { reimLister(Reim[i]); } }
 */

function getPendingReim(xhr) {

	console.log("Grabbing Pending Requests...")

	var Reims = xhr.responseText.split("Reimbursement");
	for (var i = 1; i < Reims.length; i++) {
		var splitReim = Reims[i].split("|");
		var newrow = document.createElement("tr");
		newrow.setAttribute("id", "Pending " + i);
		document.getElementById("pendingList").appendChild(newrow);
		var col1 = document.createElement("td");
		var col2 = document.createElement("td");
		var col3 = document.createElement("a");
		var col4 = document.createElement("td");
		var col5 = document.createElement("td");
		var col6 = document.createElement("td");
		var col7 = document.createElement("td");
		col1.textContent = splitReim[0];
		col2.textContent = splitReim[1];

		if (splitReim[2] == "null") {
			col3.textContent = "None";
		} else {
			col3.innerHTML = "Submitted";
			col3.href = splitReim[2];
		}
		col4.textContent = splitReim[3];
		col5.textContent = splitReim[4];
		col6.textContent = splitReim[5];
		col7.textContent = splitReim[6];

		document.getElementById("Pending " + i).appendChild(col1);
		document.getElementById("Pending " + i).appendChild(col2);

		if (splitReim[2] == "null") {
			document.getElementById("Pending " + i).appendChild(col3);
		} else {
			document.getElementById("Pending " + i).appendChild(col3);
		}
		document.getElementById("Pending " + i).appendChild(col4);
		document.getElementById("Pending " + i).appendChild(col5);
		document.getElementById("Pending " + i).appendChild(col6);
		document.getElementById("Pending " + i).appendChild(col7);

	}
}

function getApprovedReim(xhr) {

	var Reims = xhr.responseText.split("Reimbursement");
	for (var i = 1; i < Reims.length; i++) {
		var splitReim = Reims[i].split("|");
		var newrow = document.createElement("tr");
		newrow.setAttribute("id", "Approved " + i);
		document.getElementById("approvedList").appendChild(newrow);
		var col1 = document.createElement("td");
		var col2 = document.createElement("td");
		var col3 = document.createElement("a");
		var col4 = document.createElement("td");
		var col5 = document.createElement("td");
		var col6 = document.createElement("td");
		var col7 = document.createElement("td");
		col1.textContent = splitReim[0];
		col2.textContent = splitReim[1];

		if (splitReim[2] == "null") {
			col3.textContent = "None";
		} else {
			col3.innerHTML = "Submitted";
			col3.href = splitReim[2];
		}
		col4.textContent = splitReim[3];
		col5.textContent = splitReim[4];
		col6.textContent = splitReim[5];
		col7.textContent = splitReim[6];

		document.getElementById("Approved " + i).appendChild(col1);
		document.getElementById("Approved " + i).appendChild(col2);

		if (splitReim[2] == "null") {
			document.getElementById("Approved " + i).appendChild(col3);
		} else {
			document.getElementById("Approved " + i).appendChild(col3);
		}
		document.getElementById("Approved " + i).appendChild(col4);
		document.getElementById("Approved " + i).appendChild(col5);
		document.getElementById("Approved " + i).appendChild(col6);
		document.getElementById("Approved " + i).appendChild(col7);

	}
}

function getDeniedReim(xhr) {

	var Reims = xhr.responseText.split("Reimbursement");
	for (var i = 1; i < Reims.length; i++) {
		var splitReim = Reims[i].split("|");
		var newrow = document.createElement("tr");
		newrow.setAttribute("id", "Denied " + i);
		document.getElementById("deniedList").appendChild(newrow);
		var col1 = document.createElement("td");
		var col2 = document.createElement("td");
		var col3 = document.createElement("a");
		var col4 = document.createElement("td");
		var col5 = document.createElement("td");
		var col6 = document.createElement("td");
		var col7 = document.createElement("td");
		col1.textContent = splitReim[0];
		col2.textContent = splitReim[1];

		if (splitReim[2] == "null") {
			col3.textContent = "None";
		} else {
			col3.innerHTML = "Submitted";
			col3.href = splitReim[2];
		}
		col4.textContent = splitReim[3];
		col5.textContent = splitReim[4];
		col6.textContent = splitReim[5];
		col7.textContent = splitReim[6];

		document.getElementById("Denied " + i).appendChild(col1);
		document.getElementById("Denied " + i).appendChild(col2);

		if (splitReim[2] == "null") {
			document.getElementById("Denied " + i).appendChild(col3);
		} else {
			document.getElementById("Denied " + i).appendChild(col3);
		}
		document.getElementById("Denied " + i).appendChild(col4);
		document.getElementById("Denied " + i).appendChild(col5);
		document.getElementById("Denied " + i).appendChild(col6);
		document.getElementById("Denied " + i).appendChild(col7);

	}
}

function myReimsList(xhr) {
	
	console.log("Grabbing My Reims For Logged In Emp...");

	var Reims = xhr.responseText.split("Reimbursement");
	
	console.log("Reims.length: " + Reims.length);
	
	for (var i = 1; i < Reims.length; i++) {
		var splitReim = Reims[i].split("|");
		
		console.log("Split" + splitReim);
		
		var newrow = document.createElement("tr");
		newrow.setAttribute("id", "myReims " + i);
		document.getElementById("myReimList").appendChild(newrow);
		var col1 = document.createElement("td");
		var col2 = document.createElement("td");
		var col3 = document.createElement("td");
		var col4 = document.createElement("td");
		var col5 = document.createElement("td");
		var col6 = document.createElement("td");
		var col7 = document.createElement("td");
		col1.textContent = splitReim[0];
		col2.textContent = splitReim[1];

		if (splitReim[2] == "null") {
			col3.textContent = "None";
		} else {
			col3.textContent = "Submitted";
		}
		col4.textContent = splitReim[3];
		col5.textContent = splitReim[4];
		col6.textContent = splitReim[5];
		col7.textContent = splitReim[6];

		document.getElementById("myReims " + i).appendChild(col1);
		document.getElementById("myReims " + i).appendChild(col2);

		if (splitReim[2] == "null") {
			document.getElementById("myReims " + i).appendChild(col3);
		} else {
			document.getElementById("myReims " + i).appendChild(col3);
		}
		document.getElementById("myReims " + i).appendChild(col4);
		document.getElementById("myReims " + i).appendChild(col5);
		document.getElementById("myReims " + i).appendChild(col6);
		document.getElementById("myReims " + i).appendChild(col7);
	}
}

/*
function getEmpReims() {
	sendAjaxGet("http://localhost:8083/Project1/ReimsForEmpServlet", getEmpReims);
}
*/

function getReimsForEmp() {
	
	console.log("GETREIMSFOREMP");
	sendAjaxGet("http://localhost:8083/Project1/ReimsForEmpServlet", getEmpReims);
}

function getEmpReims(xhr) {
	var eachReq = xhr.responseText.split("Reimbursement");
	var user = document.getElementById("empReimsId").value;
	var myNode = document.getElementById("empReimTable");
	while (myNode.firstChild) {
		myNode.removeChild(myNode.firstChild);
	}
	var newrow = document.createElement("tr");
	newrow.setAttribute("id", "Req " + 0);
	document.getElementById("empReimTable").appendChild(newrow);
	var col1 = document.createElement("td");
	var col2 = document.createElement("td");
	var col3 = document.createElement("td");
	var col4 = document.createElement("td");
	var col5 = document.createElement("td");
	var col6 = document.createElement("td");
	var col7 = document.createElement("td");
	col1.textContent = "ID";
	col2.textContent = "Description";
	col3.textContent = "Receipt";
	col4.textContent = "Status";
	col5.textContent = "Resolved By";
	col6.textContent = "Employee ID";
	col7.textContent = "Amount";
	document.getElementById("Req " + 0).appendChild(col1);
	document.getElementById("Req " + 0).appendChild(col2);
	document.getElementById("Req " + 0).appendChild(col3);
	document.getElementById("Req " + 0).appendChild(col4);
	document.getElementById("Req " + 0).appendChild(col5);
	document.getElementById("Req " + 0).appendChild(col6);
	document.getElementById("Req " + 0).appendChild(col7);

	for (x = 1; x < eachReq.length; x++) {
		var eachVal = eachReq[x].split("|");
		if (eachVal[6] == user) {
			var newrow = document.createElement("tr");
			newrow.setAttribute("id", "Req " + x);
			document.getElementById("empReimTable").appendChild(newrow);
			var col1 = document.createElement("td");
			var col2 = document.createElement("td");
			var col3 = document.createElement("a");
			var col4 = document.createElement("td");
			var col5 = document.createElement("td");
			var col6 = document.createElement("td");
			var col7 = document.createElement("td");

			col1.textContent = eachVal[0];
			col2.textContent = eachVal[1];

			if (splitReim[2] == "null") {
				col3.textContent = "None";
			} else {
				col3.innerHTML = "Submitted";
				col3.href = splitReim[2];
			}
			col4.textContent = eachVal[3];
			col5.textContent = eachVal[4];
			col6.textContent = eachVal[5];
			col7.textContent = eachVal[6];
			document.getElementById("Req " + x).appendChild(col1);
			document.getElementById("Req " + x).appendChild(col2);
			if (splitReim[2] == "null") {
				col3.textContent = "None";
			} else {
				col3.innerHTML = "Submitted";
				col3.href = splitReim[2];
			}
			document.getElementById("Req " + x).appendChild(col4);
			document.getElementById("Req " + x).appendChild(col5);
			document.getElementById("Req " + x).appendChild(col6);
			document.getElementById("Req " + x).appendChild(col7);
		}
	}
}

function getEmployees(xhr) {

	var Emps = xhr.responseText.split("Employee");
	for (var i = 1; i < Emps.length; i++) {
		var splitEmp = Emps[i].split(":");
		var newrow = document.createElement("tr");
		newrow.setAttribute("id", "Employee " + i);
		document.getElementById("employeeList").appendChild(newrow);
		var col1 = document.createElement("td");
		var col2 = document.createElement("td");
		var col3 = document.createElement("td");
		var col4 = document.createElement("td");
		var col5 = document.createElement("td");
		var col6 = document.createElement("td");
		var col7 = document.createElement("td");
		col1.textContent = splitEmp[0];
		col2.textContent = splitEmp[1];
		col3.textContent = splitEmp[2];
		col4.textContent = splitEmp[3];
		col5.textContent = splitEmp[4];
		col6.textContent = splitEmp[5];
		col7.textContent = splitEmp[6];
		document.getElementById("Employee " + i).appendChild(col1);
		document.getElementById("Employee " + i).appendChild(col2);
		document.getElementById("Employee " + i).appendChild(col3);
		document.getElementById("Employee " + i).appendChild(col4);
		document.getElementById("Employee " + i).appendChild(col5);
		document.getElementById("Employee " + i).appendChild(col6);
		document.getElementById("Employee " + i).appendChild(col7);

	}
}