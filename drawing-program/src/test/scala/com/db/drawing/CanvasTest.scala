package com.db.drawing

import org.scalatest._

class CanvasTest extends FlatSpec {
  "With a width and height we" can "create a canvas" in {
    val c = new Canvas(20,5)

    c.print()

    assert(c.width == 20 && c.height == 5)
  }

  "With some line parameters L 1 3 7 3 we" can "draw a horizontal line" in {
    val c = new Canvas(20,5)

    c.drawLine(1,3,7,3)
    c.print()

    assert(true)
  }

  "With some line parameters L 7 1 7 3 we" can "draw a horizontal line" in {
    val c = new Canvas(20,5)

    c.drawLine(7,1,7,3)
    c.print()

    assert(true)
  }


  "With some line parameters R 15 2 20 5 we" can "draw a rectagle" in {
    val c = new Canvas(20,5)

    c.drawRect(15, 2, 20,5)
    c.print()

    assert(true)
  }

  "With some parameters we " can " draw everything" in {
    val c = new Canvas(20,5)
    c.drawLine(1,3,7,3)
    c.drawLine(7,1,7,3)
    c.drawRect(15, 2, 20,5)
    c.print()

    assert(true)

  }

}
