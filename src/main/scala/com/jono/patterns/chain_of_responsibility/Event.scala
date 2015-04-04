package com.jono.patterns.chain_of_responsibility

sealed trait Event {
  def reason: String
}

object FreeMemoryEvent extends Event {
  override val reason: String = "showMeTheFreeMemory"
}

object LoggedInUserEvent extends Event {
  override val reason: String = "shoeMeTheLoggedInUser"
}
