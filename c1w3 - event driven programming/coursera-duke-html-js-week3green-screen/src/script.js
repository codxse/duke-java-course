var FG_IMAGE;
var BG_IMAGE;
var GREEN_THRESHOLD = 100;

function loadFGImage() {
  var fileinput = document.getElementById("fgimage");
  var canvas = document.getElementById("canvas1");
  FG_IMAGE = new SimpleImage(fileinput);
  FG_IMAGE.drawTo(canvas);
}

function loadBGImage() {
  var fileinput = document.getElementById("bgimage");
  var canvas = document.getElementById("canvas2");
  BG_IMAGE = new SimpleImage(fileinput);
  BG_IMAGE.drawTo(canvas);
}

function greenScreen() {
  if (FG_IMAGE && BG_IMAGE) {
    var output = new SimpleImage(FG_IMAGE.getWidth(), FG_IMAGE.getHeight());
    for (var pixel of FG_IMAGE.values()) {
      var x = pixel.getX();
      var y = pixel.getY();
      if (pixel.getGreen() > pixel.getBlue() + pixel.getGreen()) {
        var bgPixel = BG_IMAGE.getPixel(x, y);
        output.setPixel(x, y, bgPixel);
      } else {
        output.setPixel(x, y, pixel);
      }
      var canvas1 = document.getElementById("canvas1");
      output.drawTo(canvas1);
    } 
  } else {
      alert("Image not complete");
  }
}

function clearCanvas() {
  var canvas1 = document.getElementById("canvas1");
  var canvas2 = document.getElementById("canvas2");
 
  var ctx1 = canvas1.getContext("2d");
  var ctx2 = canvas2.getContext("2d");
  ctx1.clearRect(0,0,4000,2500);
  ctx2.clearRect(0,0,4000,2500);
}


