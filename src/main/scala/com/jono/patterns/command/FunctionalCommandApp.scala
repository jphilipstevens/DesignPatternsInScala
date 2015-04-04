package com.jono.patterns.command

import com.jono.patterns.SystemInformation

import scala.collection.mutable

object FunctionalAgent {
  val history: mutable.Queue[() => Unit] = mutable.Queue.empty

  def invoke(command: => Unit): Unit = {
    history.enqueue(() => command)
    println("I will run before the command is run")
    command
  }
}

object FunctionalCommandApp extends App {

  FunctionalAgent.invoke(SystemInformation.showFreeMemory())
  FunctionalAgent.invoke(SystemInformation.showMeTheLoggedInUser())

}
