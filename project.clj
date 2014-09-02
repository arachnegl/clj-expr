(defproject hi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/tools.logging "0.3.0"]
                 [domina "1.0.2"]
                 [compojure "1.1.8"]
                 [ring/ring-jetty-adapter "1.3.1"]]
  :source-paths ["src/clj"]
  :plugins [[lein-cljsbuild "0.2.7"]]
  :main client-server.server
  :cljsbuild {
      :builds [{
          :source-path "src/cljs"
          :compiler {
              :output-to "resources/public/client.js"
              :optimizations :whitespace
              :pretty-print true}}]})
