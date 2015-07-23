package com.akomar.scalaperf

import java.util.concurrent.ThreadLocalRandom

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

@State(value = Scope.Benchmark)
class RandomSampling {

  @Benchmark
  def mathRandom(): Boolean = {
    if (math.random % 1000 == 0) true else false
  }

  @Benchmark
  def threadLocalRandom(): Boolean = {
    if (ThreadLocalRandom.current().nextDouble() < 0.001) true else false
  }

  var i: Int = 0

  @Benchmark
  def intSampling(): Boolean = {
    i += 1
    if (i % 1000 == 0) {
      i = 0
      true
    } else {
      false
    }
  }

}
