package com.db.drawing

import org.scalatest._

class CanvasTest extends FlatSpec {
  "With a canvas we" can "create one with a specific size" in {
    val c = new Canvas(0,0)

    assert(c != null)
  }

}
