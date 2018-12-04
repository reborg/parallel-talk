# Gotchas #1

* There is definitely hope!
* Hide away complexity
* Parallel is semantically different
* "drop-ins" are just a few

# Gotchas #2

* Not suitable for trivial computations
* Or small collections
* Nesting (Or how not to)
* Go mutable as an option
* Always use a profiler!

# The Future

* More functions!
* Seamless integration sequential/parallel
* Reading large inputs in parallel (no splits)
* More lifting to files (sort, distinct, etc.)
* GPU? ClojureScript?

# Resources

* https://github.com/reborg/parallel the library
* The LastFm demo is available in the /examples folder at the project home.
* [A Java fork-join framework](gee.cs.oswego.edu/dl/papers/fj.pdf) paper by Doug Lea
* [Clojure Applied](https://pragprog.com/book/vmclojeco/clojure-applied) book contains chapters dedicated to Transducers with core.async pipelines examples.
* [Clojure Essential Reference](https://livebook.manning.com/#!/book/clojure-standard-library/chapter-7), Chapter 7 Reducers and Transducers
