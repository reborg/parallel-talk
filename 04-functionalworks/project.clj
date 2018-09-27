(defproject parallel-presentation "0.1.0-SNAPSHOT"
  :description "Parallel Library Presentation Examples"
  :url "http://github.com/reborg/parallel-talk"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :jvm-opts ["-Xmx4g" "-server"]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [parallel "0.7"]
                 [criterium "0.4.4"]])
