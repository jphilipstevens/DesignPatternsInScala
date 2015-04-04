package com.jono.patterns.chain_of_responsibility

object FunctionalChainOfResponsibility extends App {

  val systemInformationHandler = freeMemoryHandler orElse loggedInUserHandler orElse defaultHandler

  systemInformationHandler(FreeMemoryEvent)
  systemInformationHandler(LoggedInUserEvent)
}
