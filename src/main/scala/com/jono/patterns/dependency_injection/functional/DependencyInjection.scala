package com.jono.patterns.dependency_injection.functional

import com.jono.patterns.SystemInformation
import com.jono.patterns.dependency_injection.{Informer, classical}


trait LoggedInUserInformer extends Informer {

  def info(): Unit = SystemInformation.showMeTheLoggedInUser()

}

trait FreeMemoryInformer extends Informer {

  def info(): Unit = SystemInformation.showFreeMemory()

}

trait KnowledgeBomb {
  self: Informer =>

  def didYouKnow(): Unit = {
    println("Did you know:")
    info()
  }
}


object DependencyInjection extends App {

  showLoggedInUser()
  showFreeMemory()

  def showLoggedInUser(): Unit = {
    val knowItAll = new KnowledgeBomb with LoggedInUserInformer
    knowItAll.didYouKnow()
  }

  def showFreeMemory(): Unit = {
    val knowItAll = new KnowledgeBomb with FreeMemoryInformer
    knowItAll.didYouKnow()
  }
}
