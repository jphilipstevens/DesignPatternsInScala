package com.jono.patterns.dependency_injection.classical

import com.jono.patterns.SystemInformation
import com.jono.patterns.dependency_injection.Informer

class LoggedInUserInformer extends Informer {
  override def info(): Unit = SystemInformation.showMeTheLoggedInUser()
}

class FreeMemoryInformer extends Informer {
  override def info(): Unit = SystemInformation.showFreeMemory()
}

class KnowledgeBomb(informer: Informer) {
  def didYouKnow(): Unit = {
    println("did you know:")
    informer.info()
  }
}

object DependencyInjection extends App {


  showLoggedInUser()
  showFreeMemory()

  def showLoggedInUser(): Unit = {
    val knowItAll = new KnowledgeBomb(new LoggedInUserInformer())
    knowItAll.didYouKnow()
  }

  def showFreeMemory(): Unit = {
    val knowItAll = new KnowledgeBomb(new FreeMemoryInformer)
    knowItAll.didYouKnow()
  }

}
