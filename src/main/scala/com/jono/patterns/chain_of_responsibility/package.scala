package com.jono.patterns

package object chain_of_responsibility {

  type FunctionalEventHandler = PartialFunction[Event, Unit]

  val defaultHandler: FunctionalEventHandler = PartialFunction(_ => ())

  val freeMemoryHandler : FunctionalEventHandler = {
    case FreeMemoryEvent => SystemInformation.showFreeMemory()
  }

  val loggedInUserHandler : FunctionalEventHandler = {
    case LoggedInUserEvent => SystemInformation.showMeTheLoggedInUser()
  }

}
