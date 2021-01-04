console.clear();

const loginBtn = document.getElementById('login');
const signupBtn = document.getElementById('signup');

loginBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode.parentNode;
	Array.from(e.target.parentNode.parentNode.classList).find((element) => {
		if(element !== "slide-up") {
			parent.classList.add('slide-up')
		}else{
			signupBtn.parentNode.classList.add('slide-up')
			parent.classList.remove('slide-up')
		}
	});
});

signupBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode;
	Array.from(e.target.parentNode.classList).find((element) => {
		if(element !== "slide-up") {
			parent.classList.add('slide-up')
		}else{
			loginBtn.parentNode.parentNode.classList.add('slide-up')
			parent.classList.remove('slide-up')
		}
	});
});

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

var HttpClient = function() {
	this.get = function(aUrl, aCallback) {
		var anHttpRequest = new XMLHttpRequest();
		anHttpRequest.onreadystatechange = function() { 
			if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
				aCallback(anHttpRequest.responseText);
		}
  
		anHttpRequest.open( "GET", aUrl, true );            
		anHttpRequest.send( null );
	}
	this.post = function(aUrl, aCallback) {
	  var anHttpRequest = new XMLHttpRequest();
	  anHttpRequest.onreadystatechange = function() { 
		  if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
			  aCallback(anHttpRequest.responseText);
	  }
  
	  anHttpRequest.open( "POST", aUrl, true );            
	  anHttpRequest.send( null );
  }
  }
  
  var client = new HttpClient();
  var host = 'http://192.168.1.106:8080/api';


const login = document.getElementById('login-button');
const signup = document.getElementById('signup-button');

const loginUsername = document.getElementById('login-username');
const signupUsername = document.getElementById("signup-username");

signup.addEventListener('click', (e) => {
	var signup_username = signupUsername.value;
	if(signup_username != null) {
		let response = httpGet(host + '/user/' + signup_username);
		console.log(response);
		if(response == []) {
			httpPost(host + '/user/register/' + signup_username);
		}
	}
	document.getElementById('signup-username').value = "";
});

login.addEventListener('click', (e) => {
	var login_username = loginUsername.value;
	if(login_username != null) {
		let response = httpGet(host + '/user/' + login_username);
		console.log(response);
			if(response != []) {
				localStorage.setItem("user", response);
				window.location.href = '../html/index.html'
		}
	}
	document.getElementById('login-username').value = "";
});