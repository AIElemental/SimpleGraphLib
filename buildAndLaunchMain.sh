#!/usr/bin/env bash
javac src/main/java/ru/aielemental/Main.java \
      src/main/java/ru/aielemental/simplegraphlib/Edge.java \
      src/main/java/ru/aielemental/simplegraphlib/DirectedEdge.java \
      src/main/java/ru/aielemental/simplegraphlib/UndirectedEdge.java \
      src/main/java/ru/aielemental/simplegraphlib/UndirectedEdge.java \
      src/main/java/ru/aielemental/simplegraphlib/Graph.java \
      src/main/java/ru/aielemental/simplegraphlib/Graphs.java
cd src/main/java
java -Xmx64m ru.aielemental.Main
