(ns hello-world.hello
  (:require [goog.net.XhrIo :as xhr]))

(defn receiver [event]
  (let [response (.-taret event)]
    (.write js/document (.getResponseText response))))

(defn post [url content]
  (xhr/send url receiver "POST" content))

(.write js/document "<p>Hello, world!</p>")
