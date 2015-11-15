package com.akomar.scalaperf


import org.openjdk.jmh.annotations.{Benchmark, Level, Scope, Setup, State}

import scala.collection.JavaConverters._

@State(value = Scope.Benchmark)
class BoxedCollectionIteration {

  var javaCollection: java.util.List[Product] = Seq[Product]().asJava
  var scalaCollection: Seq[Product] = Seq[Product]()
  var productToCompare: Product = new Product

  @Setup(Level.Iteration)
  def setupData(): Unit = {
    javaCollection = Product.generateJavaCollection()
    scalaCollection = Product.generateScalaCollection()
    productToCompare = new Product
  }

  @Benchmark
  def boxedIteration(): Boolean = {
    javaCollection.asScala.exists(_.getId == productToCompare.getId)
  }

  @Benchmark
  def scalaCollectionIteration(): Boolean = {
    scalaCollection.exists(_.getId == productToCompare.getId)
  }


}

class Product {
  val id: java.lang.Long = scala.util.Random.nextInt(10000).toLong

  def getId = id
}

object Product {
  val COLLECTION_SIZE = 1000

  def generateJavaCollection(): java.util.List[Product] = {
    val list = new java.util.ArrayList[Product]()
    for (_ <- 1 to COLLECTION_SIZE) {
      list.add(new Product)
    }
    list
  }

  def generateScalaCollection(): Seq[Product] = {
    Array.fill(COLLECTION_SIZE)(new Product)
  }
}