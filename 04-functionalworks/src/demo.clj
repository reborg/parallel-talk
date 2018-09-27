(require '[parallel.core :as p])
(require '[clojure.java.io :as io])
(require '[clojure.xml :as xml])
(require '[clojure.string :as s])

;;
;; "let" example:
;; get a mix of 35 articles from your favorite feeds.
;;

(time
  (p/let [guardian (xml-seq (xml/parse "https://www.theguardian.com/world/rss"))
        wash-post (xml-seq (xml/parse "http://feeds.washingtonpost.com/rss/rss_blogpost"))
        nytimes (xml-seq (xml/parse "http://rss.nytimes.com/services/xml/rss/nyt/World.xml"))
        wsj (xml-seq (xml/parse "http://www.wsj.com/xml/rss/3_7085.xml"))
        reuters (xml-seq (xml/parse "http://feeds.reuters.com/reuters/UKTopNews"))]
    (count (concat
             (take 10 guardian)
             (take 5 (drop 10 wash-post))
             (take 5 (drop 15 nytimes))
             (take 5 (drop 20 wsj))
             (take 10 reuters)))))

;;
;; p/slurp
;;

(time (def book (p/slurp (io/file "/usr/share/dict/words"))))

;;
;; p/slurp
;; differently from slurp, handles raw byte arrays, for example jar files
;;
(def clj (io/file "/Users/reborg/.m2/repository/org/clojure/clojure/1.9.0/clojure-1.9.0.jar"))
(import '[java.io File ByteArrayInputStream] '[java.util.zip ZipFile ZipInputStream])

(defn filenames-in-zip [bytes]
  (let [z (ZipInputStream. (ByteArrayInputStream. bytes))]
    (.getName (.getNextEntry z))))

(p/slurp clj filenames-in-zip)

;;
;; p/count
;; Example: count the number of words with no repeating letters.
;;

(require '[clojure.string :as s])

(let [txt (p/slurp (io/file "../resources/war-and-peace.txt"))
      words (s/split txt #"\s+")
      xf (comp (map s/lower-case) (map seq) (filter #(= % (distinct %))))]
  (time (count (into [] xf words)))
  (time (transduce (comp xf (map (fn [_] 1))) + words))
  (time (p/count xf words)))

;;
;; p/frequencies
;; Example: find most frequent words in some large text.
;; Note: it additionally takes xform chains
;;

(let [txt (p/slurp (io/file "../resources/war-and-peace.txt"))
      words (s/split txt #"\s+")]
  (take 5 (sort-by last >
     (time (frequencies (map s/lower-case words)))
     (time (p/frequencies (map s/lower-case words)))
     (time (p/frequencies words (map s/lower-case))))))

;;
;; p/group-by
;; Example: search for anagrams of a word in a large text.
;; e.g. "stop", "smile", "reader"
;; Note: go mutable for a nice perf boost
;;

(let [txt (p/slurp (io/file "../resources/war-and-peace.txt"))
      words (map s/lower-case (s/split txt #"\s+"))]
  (distinct (get (time (group-by sort words)) (sort "stop")))
  (distinct (get (time (p/group-by sort words)) (sort "stop")))
  (binding [p/*mutable* true]
    (distinct (into [] (.get (time (p/group-by sort words)) (sort "stop"))))))

;;
;; p/update-vals
;; Example: remove duplicate words after searching all anagrams (see above)
;; Also demonstrate some limits of parallelism on small-ish maps/trivial transforms
;;

(let [txt (p/slurp (io/file "../resources/war-and-peace.txt"))
      words (p/group-by sort (map s/lower-case (s/split txt #"\s+")))
      update-vals (fn [m f] (persistent! (reduce-kv (fn [m k v] (assoc! m k (f v))) (transient {}) m)))]
  (get (time (update-vals words distinct)) (sort "stop"))
  (get (time (p/update-vals words distinct)) (sort "stop"))
  (binding [p/*mutable* true]
    (into [] (.get (time (p/update-vals words distinct)) (sort "stop")))))

;;
;; p/sort
;; Example: sort words by length, then alphabetically
;; Also showcase going faster with native arrays
;;

(let [txt (p/slurp (io/file "../resources/war-and-peace.txt"))
      words (s/split txt #"\s+")
      bylengthalpha #(compare [(count %2) (s/lower-case %1)] [(count %1) (s/lower-case %2)])
      clean (fn [words] (pprint (take 5 (dedupe (remove #(re-find #"http" %) words)))))]
  (clean (time (sort bylengthalpha words)))
  (clean (time (p/sort bylengthalpha words))))

;;
;; p/merge-sort
;; Example: print the most recently played songs from a list of ~20M.
;; The list is about 2.5GB and is split into files 10k songs each.
;; It would be usually be served from a database.
;; See: http://www.dtic.upf.edu/~ocelma/MusicRecommendationDataset/lastfm-1K.html
;; split -a 4 -l 18702 userid-timestamp-artid-artname-traid-traname.tsv
;; num=0; for i in *; do mv "$i" "$num"; ((num++)); done
;; (int (/ 19150868 (Math/pow 2 10))) 1024 files 18702 each (a last one with 20 records only)
;;

(let [lines 19150868
      chunk-size 18702
      chunk-folder "../resources/lastfm-dataset-1K/splits/"
      fetchf (fn [ids]
               (->> (quot (last ids) chunk-size)
                    (str chunk-folder)
                    slurp
                    s/split-lines
                    (mapv #(s/split % #"\t"))))]
  (pprint (time (take 3
    (p/external-sort
      chunk-size
      #(compare (nth %2 1) (nth %1 1))
      fetchf
      (range lines))))))
