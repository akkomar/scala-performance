package com.akomar.scalaperf.arraycombinationfind

import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

import scala.util.Random

@State(value = Scope.Benchmark)
class ArrayCombinationFind {

  val input = Array.fill(1000000)(Random.nextInt(1000))

  private val SUM_TO_FIND: Int = 10

  @Benchmark
  def findSumByElement(): Boolean = {
    input.combinations(2).find(e => e(0) + e(1) == SUM_TO_FIND).isDefined
  }

  @Benchmark
  def findSumBySumMethod(): Boolean = {
    input.combinations(2).find(_.sum == SUM_TO_FIND).isDefined
  }

  @Benchmark
  def nestedForLoops(): Boolean = {
    val size = input.length
    for (a <- 0 until size) {
      for (b <- 0 until size if a != b) {
        if (input(a) + input(b) == SUM_TO_FIND) return true
      }
    }
    false
  }

  @Benchmark
  def existsSumByElement(): Boolean = {
    input.combinations(2).exists(e => e(0) + e(1) == SUM_TO_FIND)
  }

  @Benchmark
  def existsSumBySumMethod(): Boolean = {
    input.combinations(2).exists(_.sum == SUM_TO_FIND)
  }
}
