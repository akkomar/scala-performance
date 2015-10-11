    sbt "run -i 10 -wi 10 -f1 -t1 com.akomar.scalaperf.arraycombinationfind.ArrayCombinationFind.*"
    ...

    [info] # Run complete. Total time: 00:04:11
    [info]
    [info] Benchmark                                             Mode   Samples        Score  Score error    Units
    [info] c.a.s.a.ArrayCombinationFind.existsSumByElement      thrpt        10        0.257        0.010    ops/s
    [info] c.a.s.a.ArrayCombinationFind.existsSumBySumMethod    thrpt        10        0.300        0.010    ops/s
    [info] c.a.s.a.ArrayCombinationFind.findSumByElement        thrpt        10        1.091        0.047    ops/s
    [info] c.a.s.a.ArrayCombinationFind.findSumBySumMethod      thrpt        10        1.366        0.069    ops/s
    [info] c.a.s.a.ArrayCombinationFind.nestedForLoops          thrpt        10        0.730        0.035    ops/s
    [success] Total time: 262 s, completed Oct 11, 2015 1:09:25 PM


