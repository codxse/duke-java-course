function alertme() {
  alert("Hello");
}


function confirmMe() {
  var r = confirm("Pick a button");
  var txt;
  if (r === true) {
    txt = "You pressed OK!";
  } else {
    txt = "Are you sure you want to cancel?";
  }
  alert(txt)
} 

function changeColor() {
  var elm1 = document.getElementById("foo");
  var elm2 = document.getElementById("bar");
  
  if (elm1.className == "green") {
    elm1.setAttribute("class", "blue")
  } else {
    elm1.setAttribute("class", "green")
  }
  
  if (elm2.className == "green") {
    elm2.setAttribute("class", "blue")
  } else {
    elm2.setAttribute("class", "green")
  }
}

function changeText() {
  var elm1 = document.getElementById("foo");
  var elm2 = document.getElementById("bar");
  
  elm1.innerHTML = "new Foo";
  elm2.innerHTML = "new Bar";
}