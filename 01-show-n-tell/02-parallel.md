# ### 2. The library

# Parallel Library

* Some are plain drop-in replacements for the stdlib
* Others just slightly different
* Additional task oriented APIs
* Transducers support and helpers
* Documented, tested and benchmarked
* No dependencies (other than Clojure itself)

# Current Line-up 1

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/let`](#plet)                        | Parallel `let` binding.
| [`p/slurp`](#pslurp)                    | Parallel slurping files.
| [`p/count`](#pcount)                    | Transducer-aware parallel `core/count`.
| [`p/frequencies`](#pfrequencies)        | Parallel `core/frequencies`
| [`p/group-by`](#pgroup-by)              | Parallel `core/group-by`

# Current Line-up 2

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/update-vals`](#pupdate-vals)        | Updates values in a map in parallel.
| [`p/external-sort`](#pexternal-sort)    | Memory efficient, file-based, parallel merge-sort.
| [`p/sort`](#psort)                      | Parallel `core/sort`.
| [`p/fold`](#pfold-pxrf-and-pfolder)     | Transducer-aware `r/fold`.

# Current Line-up 3

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/min` and `p/max`](#pmin-and-pmax)   | Parallel `core/min` and `core/max` functions.
| [`p/distinct`](#pdistinct)   					  | Parallel version of `core/distinct`
| [`p/amap`](#pamap)                      | Parallel array transformation.
| [`p/armap`](#parmap)                    | Parallel array reversal with transformation.

# Current Line-up 4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`xf/interleave`](#xfinterleave)        | Like `core/interleave`, transducer version.
| [`xf/pmap`](#xfpmap)                    | Like `core/pmap`, transducer version.
| [`xf/identity`](#xfidentity)            | Alternative identity transducer to `core/identity`

# Demo?

# Resources

* The [parallel](https://github.com/reborg/parallel#pfold-pxrf-and-pfolder) library enables consistent stateful xforms in parallel.
* [A Java fork-join framework](gee.cs.oswego.edu/dl/papers/fj.pdf) paper by Doug Lea
* [Clojure Applied](https://pragprog.com/book/vmclojeco/clojure-applied) book contains chapters dedicated to Transducers with core.async pipelines examples.
* [Standard Library book](https://livebook.manning.com/#!/book/clojure-standard-library/chapter-7), Chapter 7 Reducers and Transducers
