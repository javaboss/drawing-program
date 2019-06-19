package com.db.drawing

import scala.io.StdIn.readLine

object DrawingProgram extends App {
  println("Drawing Program")

  var input: String = ""
  var canvas = new Canvas

  while (true) {
    println("enter command: ")

    input = readLine()

    val args = new Args(input)
    input = args.command

    canvas = new CommandProcessor(args, canvas).process()
    canvas.print()
  }
}

class CommandProcessor(args: Args, canvas: Canvas) {

  if (args.command != "Q" && args.params.length == 0)
    throw new IllegalArgumentException("Incorrect command format")

  def process(): Canvas = {
    args.command match {
      case "Q" =>
        val c = new QuitCommand(args, canvas)
        if (c.validate) c.execute()
        System.exit(0)

      case "C" =>
        if (args.params.length < 2) throw new IllegalArgumentException("C: Incorrect parameters")

        println("New Canvas")
        return new Canvas((args.params(0), args.params(1)))

      case "L" =>
        val c = new LineCommand(args, canvas)
        if (c.validate) c.execute()

      case "R" =>
        val c = new RectangleCommand(args, canvas)
        if (c.validate) c.execute()

      case _ => throw new IllegalArgumentException("Incorrect command format")
    }

    canvas
  }
}