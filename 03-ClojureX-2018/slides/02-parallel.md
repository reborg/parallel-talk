# Thinking it differently

* Task oriented
* Predictable
* Easy to use
* Like the standard library …

🤔

#

![](../resources/challenge-accepted.jpg)

# Principles

* Modelling standard library functions
* Drop-in replacement (if possible)
* Transducers support
* New functions on top
* Well documented, benchmarked, tested.

# Current Line-up 1/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/let`](#plet)                        | Parallel `let` binding.
| [`p/slurp`](#pslurp)                    | Parallel slurping files.
| [`p/do`](#pdo)                          | Parallel `do` forms.
| [`p/doto`](#pdoto)                      | Parallel `doto` forms.
| [`p/count`](#pcount)                    | Transducer-aware parallel `core/count`.

# Current Line-up 2/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/frequencies`](#pfrequencies)        | Parallel `core/frequencies`
| [`p/group-by`](#pgroup-by)              | Parallel `core/group-by`
| [`p/update-vals`](#pupdate-vals)        | Updates vals in a map parallel.
| [`p/sort`](#psort)                      | Parallel `core/sort`.
| [`p/external-sort`](#pexternal-sort)    | Memory efficient, file-based, parallel merge-sort.

# Current Line-up 3/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/fold`](#pfold-pxrf-and-pfolder)     | Transducer-aware `r/fold`.
| [`p/transduce`](#ptransduce)            | `transduce` based on `p/fold`.
| [`p/process-folder`](#pprocess-folder)  | Process files in parallel.
| [`p/min` and `p/max`](#pmin-and-pmax)   | Parallel `core/min` and `core/max`.
| [`p/distinct`](#pdistinct)   					  | Parallel `core/distinct`

# Current Line-up 4/4

| Name                                    | Description
|-----------------------------------------| ---------------------------------------------------
| [`p/amap`](#pamap)                      | Parallel array transformation.
| [`p/armap`](#parmap)                    | Parallel array reversal transformation.
| [`xf/interleave`](#xfinterleave)        | `core/interleave`, transducer version.
| [`xf/pmap`](#xfpmap)                    | `core/pmap`, transducer version.
| [`xf/identity`](#xfidentity)            | Alternative identity transducer

# Quick REPL
