#  Last.FM dataset

* Something more challenging.
* Interesting large data set.
* Play counts for 360k users  (1.5G, 1.7M lines tsv)
* Detailed plays for 1k users (2.4G, 1.9M lines tsv)
* User demographics

# Approaching the problem

* Laziness: load and process to reduce the dataset.
* Transients: create and return the initial collection.
* Transducers: avoid unnecessary sequence wrapping.
* Careful with eager functions (frequencies, sort, etc.)
* All the best practices and tricks I know!

# More Demo
