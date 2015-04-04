package com.jono.patterns.command

import com.jono.patterns.SystemInformation

import scala.collection.mutable

trait Command {

  def execute(): Unit

}

object FreeMemoryCommand extends Command {
  override def execute(): Unit = SystemInformation.showFreeMemory()
}

object LoggedInUserCommand extends Command {
  override def execute(): Unit = SystemInformation.showMeTheLoggedInUser()
}

object OperatingSystemAgent {
  val history: mutable.Queue[Command] = mutable.Queue.empty

  def invoke(command: Command): Unit = {
    history.enqueue(command)
    command.execute()
  }
}

object ClassicalCommandApp extends App {
  OperatingSystemAgent.invoke(FreeMemoryCommand)
  OperatingSystemAgent.invoke(LoggedInUserCommand)
}