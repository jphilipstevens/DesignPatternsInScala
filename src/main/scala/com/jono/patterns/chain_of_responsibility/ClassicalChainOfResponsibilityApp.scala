package com.jono.patterns.chain_of_responsibility

import com.jono.patterns.SystemInformation

trait EventHandler {
  def next: Option[EventHandler]

  def handle(event: Event): Unit =
    if (canHandle(event)) handleEvent(event)
    else next.foreach(nextHandler => nextHandler.handle(event))


  def canHandle(event: Event): Boolean

  def handleEvent(event: Event): Unit
}


case class FreeMemoryEventHandler(next: Option[EventHandler]) extends EventHandler {

  override def canHandle(event: Event): Boolean = event.reason.equals("showMeTheFreeMemory")

  override def handleEvent(event: Event): Unit = SystemInformation.showFreeMemory()
}


case class LoggedInUserEventHandler(next: Option[EventHandler]) extends EventHandler {

  override def canHandle(event: Event): Boolean = event.reason.equals("shoeMeTheLoggedInUser")

  override def handleEvent(event: Event): Unit = SystemInformation.showMeTheLoggedInUser()
}

object ClassicalChainOfResponsibilityApp extends App {

  val loggedInUserEvent = LoggedInUserEventHandler(None)
  val freeMemoryEvent = FreeMemoryEventHandler(Some(loggedInUserEvent))

  freeMemoryEvent.handle(FreeMemoryEvent)
  freeMemoryEvent.handle(LoggedInUserEvent)

}
