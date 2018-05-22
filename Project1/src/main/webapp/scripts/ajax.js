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

function getEmpProfile (xhr){
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
	document.getElementById("ism").value= eachVal[5];
	document.getElementById("em").value = eachVal[6];
}	

function getAllReimbursements (xhr){
	var Reim = xhr.responseText.split("Reimbursement");
	
	for (let i = 0; i < Reim.length; i++) {
		reimLister(Reim[i]);                                                               
	}
}
