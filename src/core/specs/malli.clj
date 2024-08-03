(ns core.specs.malli
  (:require [malli.core :as m]))

;;;; destructure

(def local-name
  (m/schema [:and simple-symbol? [:not= '&]]))


#_(s/def ::binding-form
  (s/or :local-symbol ::local-name
        :seq-destructure ::seq-binding-form
        :map-destructure ::map-binding-form))

;; sequential destructuring

;(s/def ::seq-binding-form
;  (s/and vector?
;         (s/cat :forms (s/* ::binding-form)
;                :rest-forms (s/? (s/cat :ampersand #{'&} :form ::binding-form))
;                :as-form (s/? (s/cat :as #{:as} :as-sym ::local-name)))))
;
;;; map destructuring
;
(def form-keys )
;(s/def ::keys (s/coll-of ident? :kind vector?))
;(s/def ::syms (s/coll-of symbol? :kind vector?))
;(s/def ::strs (s/coll-of simple-symbol? :kind vector?))
;(s/def ::or (s/map-of simple-symbol? any?))
;(s/def ::as ::local-name)
;
;(s/def ::map-special-binding
;  (s/keys :opt-un [::as ::or ::keys ::syms ::strs]))
;
;(s/def ::map-binding (s/tuple ::binding-form any?))
;
;(s/def ::ns-keys
;  (s/tuple
;    (s/and qualified-keyword? #(-> % name #{"keys" "syms"}))
;    (s/coll-of simple-symbol? :kind vector?)))
;
;(s/def ::map-bindings
;  (s/every (s/or :map-binding ::map-binding
;                 :qualified-keys-or-syms ::ns-keys
;                 :special-binding (s/tuple #{:as :or :keys :syms :strs} any?)) :kind map?))
;
;(s/def ::map-binding-form (s/merge ::map-bindings ::map-special-binding))