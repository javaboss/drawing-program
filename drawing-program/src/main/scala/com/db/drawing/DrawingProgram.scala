package com.db.drawing

import scala.io.StdIn.readLine

object DrawingProgram extends App {
  println("Drawing Program")

  var input: String = ""
  var canvas = new Canvas

  while (input != "Q") {
    println("enter command: ")

    input = readLine()

    val command = new Command(input)
    input = command.command

    if (input != "Q") {
      canvas = new CommandProcessor(command, canvas).process()
      canvas.print()
    }
  }

  class Command(input: String) {
    private val args = input.split(" ").toList

    val command: String = args(0).toUpperCase
    val params: List[Int] = args.drop(1).map(_.toInt)
  }

  class CommandProcessor(c: Command, canvas: Canvas) {

    if (c.command != "Q" && c.params.length == 0)
      throw new IllegalArgumentException("Incorrect command format")

    def process(): Canvas = {
      c.command match {
        case "Q" =>
          println("Quit")

        case "C" =>
          if (c.params.length < 2) throw new IllegalArgumentException("C: Incorrect parameters")

          println("New Canvas")
          return new Canvas((c.params(0), c.params(1)))

        case "L" =>
          if (c.params.length < 4) throw new IllegalArgumentException("L: Incorrect parameters")

          println("Line")
          canvas.drawLine(c.params(0), c.params(1), c.params(2), c.params(3))

        case "R" =>
          if (c.params.length < 4) throw new IllegalArgumentException("L: Incorrect parameters")

          println("Rectangle")
          canvas.drawRect(c.params(0), c.params(1), c.params(2), c.params(3))

        case _ => throw new IllegalArgumentException("Incorrect command format")
      }

      canvas
    }
  }
}
