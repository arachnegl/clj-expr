(ns client-server.client
  (:require [goog.net.XhrIo :as xhr]
            [domina :as dom]
            [domina.events :as events]))

(def result-id "eval-result")
(def expr-id "eval-expr")
(def button-id "eval-button")

(defn receive-result [event]
  (dom/set-text! (dom/by-id result-id)
                 (.getResponseText (.-target event))))

(defn post-for-eval [expr-str]
  (xhr/send "/eval" receive-result "POST" expr-str))

(defn get-expr []
  (.-value (dom/by-id expr-id)))

(defn ^:export main []
  (events/listen! (dom/by-id button-id)
                  :click
                  (fn [event]
                    (post-for-eval (get-expr))
                    (events/stop-propagation event)
                    (events/prevent-default event))))
