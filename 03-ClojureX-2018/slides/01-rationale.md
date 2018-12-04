# Context

* Circa 2007-2008
* CPU top speed achieved
* Increasing number of cores
* Push to leverage multiple cores
* FP, The Return

# Clojure Parallelism

* Comes with a set of parallel APIs
* `pmap`, `pvalues`, `pcalls` (lazy-sequential-chunked)
* `reducers/fold` (work-stealing fork-join)
* Build your own with `future`, `agent`, etc.
* `core.async` pipelines (external lib)

# All nice stuff but

* Low level
* Not necessarily easy to use
* Even more to use correctly
* And what about stateful transducers?
* Dependency on chunk size
