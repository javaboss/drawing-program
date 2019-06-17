package com.db.drawing

object Canvas {
}

class Canvas(val width: Int, val height: Int) {

  private val dimX = width + 2
  private val dimY = height + 2

  private val matrix = Array.ofDim[Char](dimY, dimX)

  if (width < 0 || height < 0) throw new IllegalArgumentException("Canvas size cannot be negative")

  println(s"Canvas [x = $width], [y = $height]")
  createBorder()

  private def createBorder(): Unit = {
    for (y <- 0 to dimY-1) {
      for (x <- 0 to dimX-1) {
        if (y == 0 || y == dimY-1) matrix(y)(x) = '-'
        else if (x == 0 || x == dimX-1) matrix (y)(x) = '|'
        else matrix(y)(x) = ' '
      }
    }
  }

  def drawLine(startX: Int, startY: Int, endX: Int, endY: Int): Unit = {
    if (startY == endY) {
      for (i <- startX to endX) {
        matrix(startY)(i) = 'X'
      }
    }
    else if (startX == endX) {
      for (i <- startY to endY) {
        matrix(i)(startX) = 'X'
      }
    }
  }

  def drawRect(startX: Int, startY: Int, endX: Int, endY: Int): Unit = {
    drawLine(startX, startY, endX, startY)
    drawLine(startX, endY, endX, endY)
    drawLine(startX, startY+1, startX, endY-1)
    drawLine(endX, startY+1, endX, endY-1)
  }

  def print(): Unit = {
    for (y <- 0 to dimY-1) {
      var row: String = ""
      for (x <- 0 to dimX-1) {
        row += matrix(y)(x)
      }
      println(row)
    }
  }

}
