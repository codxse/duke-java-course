var canvas1 = document.getElementById("c1");

function doYellowCanvas1() {
  canvas1.style.backgroundColor = "yellow";
  var ctx = canvas1.getContext("2d");
  ctx.fillStyle = "red";
  ctx.fillRect(10, 10, 50, 50);
  ctx.fillRect(70, 10, 50, 50);
  
  ctx.fillStyle = "black";
  ctx.font = "20px sans-serif";
  ctx.fillText("Hello World", 15, 85);
}

function doLimeCanvas1() {
  canvas1.style.backgroundColor = "lime";
  var ctx = canvas1.getContext("2d");
  ctx.clearRect(0,0,400,250);
}