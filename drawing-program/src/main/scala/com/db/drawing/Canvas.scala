package com.db.drawing

object Canvas {
}

class Canvas(width: Int, height: Int) {

  if (width < 0 || height < 0) throw new IllegalArgumentException("Canvas size cannot be negative")

  println(s"Canvas [x = $width], [y = $height]")
}
