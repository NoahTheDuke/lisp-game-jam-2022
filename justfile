default:
    @just --list

repl:
    clojure -M:dev:test:lib/reloaded:repl/rebel

test *args:
    clojure -M:dev:test {{args}}

run:
    clojure -M:run
