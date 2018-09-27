# Context

* Circa 2007-2008
* CPU top speed achieved
* Cores to increase further
* Push to leverage multiple cores
* Functional Programming return

# Clojure Parallelism

* Basic set of parallel APIs:
* `pmap` `pvalues` `pcalls` (lazy, sequential, chunked)
* `reducers/fold` (work-stealing, fork-join)
* Custom with `future`, `agent`, etc.
* `core.async` pipelines (external lib)

# Problems

* Powerful, but somewhat low level
* Not necessarily easy to use
* Even more to use correctly
* Inconsistencies with stateful xforms
* Chunk size dependency (`pmap`)
