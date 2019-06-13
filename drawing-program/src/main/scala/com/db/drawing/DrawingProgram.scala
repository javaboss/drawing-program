package com.db.drawing

import scala.io.StdIn.readLine

object DrawingProgram extends App {
  println("Drawing Program")

  var command: String = ""

  while (command != "q") {
    println("Command: ")

    command = readLine()

    println("Line: " + command)

    val params = command.split(" ").toList

    println("params size = " + params.size)
    println("params length = " + params.length)
    println("params is empty? " + params.isEmpty)

    for (i <- params) println("Split: '" + i + "'")

    val processor = new CommandProcessor(params)
    val c = processor.process()
  }

  class CommandProcessor(params: List[String]) {
    def process(): Canvas = {
      if (params(0).toUpperCase != "Q" && params.length == 1)
          throw new IllegalArgumentException("Incorrect command format")

      val command = params(0)

      command.toUpperCase match {
        case "Q" => {
          println("Quit")
          return new Canvas(0,0)
        }

        case "C" => {
          if (params.length < 3) throw new IllegalArgumentException("Incorrect parameters")

          println("New Canvas")
          return new Canvas(params(1).toInt, params(2).toInt)
        }

        case "L" => {

        }

        case _ => throw new IllegalArgumentException("Incorrect command format")
      }

    }
  }
}
