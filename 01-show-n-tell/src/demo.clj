(require '[parallel.core :as p])

;; let

(time
  (let [a (Thread/sleep 1000)
        b (Thread/sleep 1000)
        c (Thread/sleep 1000)]
    (= a b c)))

(time
  (p/let [a (Thread/sleep 1000)
          b (Thread/sleep 1000)
          c (Thread/sleep 1000)]
    (= a b c)))

;; slurping war and peace (3.2M)

(require '[clojure.java.io :as io])
(time (def book (slurp (io/file "resources/war-and-peace.txt"))))
(time (def book (p/slurp (io/file "resources/war-and-peace.txt"))))

;; frequencies

(take 5 (sort-by last > (time (frequencies (map #(.toLowerCase ^String %) (re-seq #"\S+" book))))))
(take 5 (sort-by last > (time (p/frequencies (map #(.toLowerCase ^String %) (re-seq #"\S+" book))))))

; distinct

(let [v (vec (apply concat (repeat 200 (range 10000))))]
  (time (count (distinct v))))

(let [v (vec (apply concat (repeat 200 (range 10000))))]
  (time (count (p/distinct v))))
