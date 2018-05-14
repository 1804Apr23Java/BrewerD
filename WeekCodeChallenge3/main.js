var book = { title: "", author: "", pDate: "", cover: "" }

function Book(title, author, pDate, cover) {
    this.title = title;
    this.author = author;
    this.pDate = pDate;
    this.cover = cover;
}


var b0 = new Book("Turtles All The Way Down", "John Green", "2017", "images/turtles.jpg");
var b1 = new Book("Going For Broke", "Finance Girl", "2008", "images/finance.jpg");
var b2 = new Book("Making Things Happen", "Mrs. Author", "2010", "images/business.png");

var bList = [b0, b1, b2]

var html = "<table border='1|1' align='center'>";
for (var i = 0; i < bList.length; i++) {
    html += "<tr>";
    html += "<td>" + bList[i].title + "</td>";
    html += "<td>" + bList[i].author + "</td>";
    html += "<td>" + bList[i].pDate + "</td>";
    html += "<td><img src=" + bList[i].cover + " alt='Book Cover' height='200'></td>";

    html += "</tr>";
}

html += "</table>";
document.getElementById("box").innerHTML = html;

function submitted() {
    var newb = [document.getElementById('titl').value, document.getElementById('auth').value, document.getElementById('date').value, document.getElementById('cov').value];
    
    var b4 = new Book(newb[0], newb[1], newb[2], newb[3]);

    bList.push(b4);

    console.log(bList);

    var html = "<table border='1|1'>";
    for (var i = 0; i < bList.length; i++) {
        html += "<tr>";
        html += "<td>" + bList[i].title + "</td>";
        html += "<td>" + bList[i].author + "</td>";
        html += "<td>" + bList[i].pDate + "</td>";
        html += "<td><img src=" + bList[i].cover + " alt='Book Cover' height='200'></td>";

        html += "</tr>";
    }
}
