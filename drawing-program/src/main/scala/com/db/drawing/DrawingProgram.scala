package com.db.drawing

import scala.io.StdIn.readLine

object DrawingProgram extends App {
  println("Drawing Program")

  var input: String = ""

  while (input != "Q") {
    println("enter command: ")

    input = readLine()

    val c = new Command(input)
    input = c.command

    if (input != "Q") {
      val canvas = new CommandProcessor(c).process()
      canvas.print()
    }
  }

  class Command(input: String) {
    private val args = input.split(" ").toList

    val command: String = args(0).toUpperCase
    val params: List[Int] = args.drop(1).map(_.toInt)

    println("COMMAND: " + command)
    println("PARAMS")
    for (i <- params) println(i)
  }

  class CommandProcessor(c: Command) {

    if (c.command != "Q" && c.params.length == 0)
      throw new IllegalArgumentException("Incorrect command format")

    def process(): Canvas = {
      c.command match {
        case "Q" =>
          println("Quit")
          return new Canvas(0,0)

        case "C" =>
          if (c.params.length < 3) throw new IllegalArgumentException("C: Incorrect parameters")

          println("New Canvas")
          return new Canvas((c.params(1), c.params(2)))
/*
        case "L" =>
          if (params.length < 4) throw new IllegalArgumentException("L: Incorrect parameters")

          println("Line")
          return new Canvas(params(1).toInt, params(2).toInt, params(3).toInt, params(4).toInt)
*/
        case _ => throw new IllegalArgumentException("Incorrect command format")
      }
    }
  }
}
