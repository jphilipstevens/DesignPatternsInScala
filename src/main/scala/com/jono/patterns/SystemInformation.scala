package com.jono.patterns

object SystemInformation {
  def showFreeMemory(): Unit =
    println(s"You have ${Runtime.getRuntime.freeMemory()} bytes free memory for this app")

  def showMeTheLoggedInUser(): Unit =
    println(s"Your user name is  ${System.getProperty("user.name")}")

}