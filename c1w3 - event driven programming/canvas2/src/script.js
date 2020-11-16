var clrInput = document.getElementById("clrBtn");
var canvas = document.getElementById("myCanvas");
var rangeInput = document.getElementById("rangeInput");

function pickColor() {
  var selectedColor = clrInput.value;
  canvas.style.backgroundColor = selectedColor;
  var ctx = canvas.getContext("2d");
}

function changeColor() {
  canvas.style.backgroundColor = "lime";
}

function doSquare() {
  var size = rangeInput.value;
  var ctx = canvas.getContext("2d");
  ctx.fillStyle = "yellow";
  ctx.clearRect(0,0,400,250);
  ctx.fillRect(10, 10, size, size);
}
