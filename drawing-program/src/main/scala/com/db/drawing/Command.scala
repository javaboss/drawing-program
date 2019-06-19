package com.db.drawing

abstract class Command {
  def validate : Boolean
  def execute : Unit
}

class Args(input: String) {
  private val args = input.split(" ").toList

  val command: String = args(0).toUpperCase
  val params: List[Int] = args.drop(1).map(_.toInt)
}

class QuitCommand(args: Args, canvas: Canvas) extends Command {
  def validate : Boolean = true

  def execute(): Unit = println("Quit")
}

class LineCommand(args: Args, canvas: Canvas) extends Command {
  def validate : Boolean = if (args.params.length == 4) true else false

  def execute(): Unit = {
    println("Line")
    canvas.drawLine(args.params(0), args.params(1), args.params(2), args.params(3))
  }
}

class RectangleCommand(args: Args, canvas: Canvas) extends Command {
  def validate : Boolean = if (args.params.length == 4) true else false

  def execute(): Unit = {
    println("Rectangle")
    canvas.drawRect(args.params(0), args.params(1), args.params(2), args.params(3))
  }
}

