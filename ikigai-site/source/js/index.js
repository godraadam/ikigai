var welcome_text = document.getElementById("welcome");
var user = JSON.parse(localStorage.getItem("user"));
var get_started_button = document.getElementById("done_button");

welcome_text.innerHTML = "Welcome " + user.userName + ".";

get_started_button.addEventListener('click', (e) => {
    window.location.href = '../html/main.html'
});