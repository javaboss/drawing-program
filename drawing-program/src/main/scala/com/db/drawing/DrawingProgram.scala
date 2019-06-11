package com.db.drawing

import scala.io.StdIn.readLine

object DrawingProgram extends App {
  println("Drawing Program")

  var command: String = ""

  while (command != "q") {
    println("Command: ")

    command = readLine()

    println("Line: " + command)
  }

}
