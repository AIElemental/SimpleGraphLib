package ru.aielemental.tests;

import java.util.Objects;

import simplegraphlib.Graphs;

public class Main {

    public static void main(String[] args) {
        var directedGraph = Graphs.getDirectedGraph(String.class);
        directedGraph.addVertex("Paris");
        directedGraph.addVertex("Moscow");
        directedGraph.addVertex("Munich");
        directedGraph.addVertex("Oslo");
        directedGraph.addVertex("Tallinn");
        directedGraph.addVertex("London");
        directedGraph.addEdge("London", "Paris");
        directedGraph.addEdge("Paris", "Munich");
        directedGraph.addEdge("Munich", "Moscow");
        directedGraph.addEdge("Oslo", "Tallinn");
        directedGraph.addEdge("Oslo", "Munich");
        directedGraph.addEdge("Tallinn", "Moscow");
        System.out.println("City graph");
        System.out.println(directedGraph);
        System.out.println();
        System.out.println("Path from Paris to Moscow?");
        System.out.println(directedGraph.getPath("Paris", "Moscow"));
        System.out.println();
        System.out.println("Path from Moscow to Moscow?");
        System.out.println(directedGraph.getPath("Moscow", "Moscow"));
        System.out.println();
        System.out.println("Path from Moscow to Paris?");
        System.out.println(directedGraph.getPath("Moscow", "Paris"));
        System.out.println();
        System.out.println("Path from Oslo to Moscow?");
        System.out.println(directedGraph.getPath("Oslo", "Moscow"));
        System.out.println();
        System.out.println("Path from Moscow to Oslo?");
        System.out.println(directedGraph.getPath("Moscow", "Oslo"));
        System.out.println();
        var joe = new Person("Joe Smith", 35);
        var sarah = new Person("Sarah Smith", 32);
        var michael = new Person("Michael Smith", 70);
        var anthony = new Person("Anthony SMith", 5);
        var elizabeth = new Person("Elizabeth Koval", 25);
        var igor = new Person("Igor Koval", 28);
        var prudence = new Person("Prudence Koval", 6);

        var undirectedGraph = Graphs.getUndirectedGraph(Person.class);
        undirectedGraph.addVertex(joe);
        undirectedGraph.addVertex(sarah);
        undirectedGraph.addVertex(michael);
        undirectedGraph.addVertex(anthony);
        undirectedGraph.addVertex(elizabeth);
        undirectedGraph.addVertex(igor);
        undirectedGraph.addVertex(prudence);

        undirectedGraph.addEdge(joe, sarah);
        undirectedGraph.addEdge(joe, michael);
        undirectedGraph.addEdge(joe, anthony);
        undirectedGraph.addEdge(sarah, anthony);

        undirectedGraph.addEdge(elizabeth, igor);
        undirectedGraph.addEdge(elizabeth, prudence);
        undirectedGraph.addEdge(igor, prudence);



        System.out.println("Person graph");
        System.out.println(undirectedGraph);
        System.out.println();
        System.out.println("Path from Michael to Igor before anthony-prudence edge");
        System.out.println(undirectedGraph.getPath(michael, igor));
        System.out.println();
        undirectedGraph.addEdge(anthony, prudence);
        System.out.println("Path from Michael to Igor after anthony-prudence edge");
        System.out.println(undirectedGraph.getPath(michael, igor));
    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return '{' + name + ", " + age + '}';
        }
    }
}
