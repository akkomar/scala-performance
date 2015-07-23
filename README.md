# JMH benchmarks with sbt-jmh plugin

In order to run selected benchmark:

    run -i 10 -wi 10 -f1 -t1 org.openjdk.jmh.samples.RandomSampling.*


## Results
# RandomSampling

    run com.akomar.scalaperf.RandomSampling.*
(default settings, 10 forks/20 warmup iterations/20 iterations)

```shell
[info] # Run complete. Total time: 00:24:16
[info] 
[info] Benchmark                                  Mode   Samples        Score  Score error    Units
[info] c.a.s.RandomSampling.intSampling          thrpt       200 190644027.655  4016333.505    ops/s
[info] c.a.s.RandomSampling.mathRandom           thrpt       200 29451572.193    50171.519    ops/s
[info] c.a.s.RandomSampling.threadLocalRandom    thrpt       200 186716776.611  2793124.170    ops/s
```
