var IMAGE;

function upload() {
  var fileinput = document.getElementById("finput");
  var canvas = document.getElementById("canvas");
  IMAGE = new SimpleImage(fileinput);
  IMAGE.drawTo(canvas);
}

function makeGray() {
  if (IMAGE) {
    for (var pixel of IMAGE.values()) {
      var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
      pixel.setRed(avg);
      pixel.setGreen(avg);
      pixel.setBlue(avg);
    }
    var canvas = document.getElementById("canvas");
    IMAGE.drawTo(canvas);
  }
}

