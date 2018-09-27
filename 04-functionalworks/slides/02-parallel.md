# Can we approach it differently?

* Task oriented API
* Predictable semantic
* Easy to use
* Documented

# The Parallel Library

* Experimenting ideas in a library
* https://github.com/reborg/parallel
* Documented, tested and benchmarked
* No dependencies (other than Clojure itself)

# At a glance

* Modeled on existing functions from the stdlib
* Drop-in replacement (when possible)
* A few brand new functions
* Some specific transducers support

# Current Line-up 1/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/let`](#plet)                        | Parallel `let` binding.
| [`p/slurp`](#pslurp)                    | Parallel slurping files.
| [`p/count`](#pcount)                    | Transducer-aware parallel `core/count`.
| [`p/frequencies`](#pfrequencies)        | Parallel `core/frequencies`
| [`p/group-by`](#pgroup-by)              | Parallel `core/group-by`

# Current Line-up 2/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/update-vals`](#pupdate-vals)        | Updates values in a map in parallel.
| [`p/external-sort`](#pexternal-sort)    | Memory efficient, file-based, parallel merge-sort.
| [`p/sort`](#psort)                      | Parallel `core/sort`.
| [`p/fold`](#pfold-pxrf-and-pfolder)     | Transducer-aware `r/fold`.

# Current Line-up 3/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/min` and `p/max`](#pmin-and-pmax)   | Parallel `core/min` and `core/max` functions.
| [`p/distinct`](#pdistinct)   					  | Parallel version of `core/distinct`
| [`p/amap`](#pamap)                      | Parallel array transformation.
| [`p/armap`](#parmap)                    | Parallel array reversal with transformation.

# Current Line-up 4/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`xf/interleave`](#xfinterleave)        | Like `core/interleave`, transducer version.
| [`xf/pmap`](#xfpmap)                    | Like `core/pmap`, transducer version.
| [`xf/identity`](#xfidentity)            | Alternative identity transducer to `core/identity`

# DEMO TIME!
