#!/usr/bin/env bash
javac src/main/java/ru/aielemental/tests/Main.java \
      src/main/java/ru/aielemental/tests/simplegraphlib/Edge.java \
      src/main/java/ru/aielemental/tests/simplegraphlib/DirectedEdge.java \
      src/main/java/ru/aielemental/tests/simplegraphlib/UndirectedEdge.java \
      src/main/java/ru/aielemental/tests/simplegraphlib/UndirectedEdge.java \
      src/main/java/ru/aielemental/tests/simplegraphlib/Graph.java \
      src/main/java/ru/aielemental/tests/simplegraphlib/Graphs.java
cd src/main/java
java -Xmx64m ru.aielemental.tests.Main
