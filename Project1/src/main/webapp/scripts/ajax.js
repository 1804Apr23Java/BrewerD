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
}

function getAllReimbursements(xhr) {
	var Reim = xhr.responseText.split("Reimbursement");

	for (let i = 0; i < Reim.length; i++) {
		reimLister(Reim[i]);
	}
}

function getPendingReim(xhr) {

	var Reims = xhr.responseText.split("Reimbursement");
	for (var i = 1; i < Reims.length; i++) {
		var splitReim = Reims[i].split(":");
		var newrow = document.createElement("tr");
		newrow.setAttribute("id", "Pending " + i);
		document.getElementById("PendingList").appendChild(newrow);
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
