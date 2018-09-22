# ### 1. Rationale

# FP promise

* Circa 2007-2008
* CPU top speed achieved
* CPU cores will increase in number
* How software can leverage multiple cores
* FP better than OO for concurrency (and more)

# Clojure Parallelism

* Not distributed parallel APIs:
* `pmap` (lazy, sequential, constrained)
* `r/fold` (work-stealing, fork-join)
* Custom (with `future`, `agent`, etc.)
* `core.async` pipelines

# Problems

* Not necessarily easy to use
* Even more to use correctly
* Type dependency, chunk size
* Powerful but "low level"
* Not task oriented

# Solution

* Task oriented approach
* Mimic standard library functions
* Sort out type conversion, chunk sizes
* Documentation and examples
