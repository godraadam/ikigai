function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function httpPost(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function httpPut(theUrl) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "PUT", theUrl, false); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

var card_image_url = document.getElementById("image");
var card_title = document.getElementById("title");
var card_description = document.getElementById("description");
var card_done_button = document.getElementById("done_button");
var card_category = document.getElementById("category");

var maindiv = document.getElementById("maindiv");

var user = JSON.parse(localStorage.getItem("user"));
var host = 'http://192.168.1.106:8080/api';

console.log(user);

var tasks = JSON.parse(httpGet(host + '/task/' + user.id));

if(tasks.length == 0) {
    maindiv.innerHTML = 
    `
        <p>You're awesome.</p>
    `
    maindiv.style.fontSize = "50px";
    maindiv.style.position = "absolute";
    maindiv.style.left = "550px";
    maindiv.style.top = "280px";
}
else {
    console.log("here");
    card_title.innerHTML = tasks[0].title;
    card_description.innerHTML = tasks[0].description;
    card_image_url.style.background = `url('${tasks[0].imageUrl}')`;    
    card_image_url.style.backgroundSize = "400px";
}

var i = 0;

card_done_button.addEventListener('click', (e) => {
    httpPut(host + '/user/' + user.id + '/task/' + tasks[i].id);
    i++;
    console.log(i);
    console.log(tasks.length);
    if(i >= tasks.length) {
        maindiv.innerHTML = 
        `
            <p>You're awesome.</p>
        `
        maindiv.style.fontSize = "50px";
        maindiv.style.position = "absolute";
        maindiv.style.left = "550px";
        maindiv.style.top = "280px";
    } else {
        card_title.innerHTML = tasks[i].title;
        card_image_url.style.background = `url('${tasks[i].imageUrl}')`;
        card_image_url.style.backgroundSize = "400px";
        card_description.innerHTML = tasks[i].description;
    }
});