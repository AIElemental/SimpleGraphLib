package ru.aielemental.tests.simplegraphlib;

/**
 * @author Artem Bulanov
 * Created at 2019-10-06
 */
public class Graphs {

    public static <V> Graph<V> getUndirectedGraph(Class<V> vertexType) {
        return new Graph<>(UndirectedEdge::new);
    }

    public static <V> Graph<V> getDirectedGraph(Class<V> vertexType) {
        return new Graph<>(DirectedEdge::new);
    }

    private Graphs() {
    }
}
