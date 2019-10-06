package ru.aielemental.tests.simplegraphlib;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import simplegraphlib.Graphs;

/**
 * @author Artem Bulanov
 * Created at 2019-10-06
 */
public class TestUndirectedGraphs {

    @Test
    public void testSelfSearch() {
        var graph = Graphs.getUndirectedGraph(Integer.class);
        graph.addVertex(1);
        Assert.assertEquals(List.of(), graph.getPath(1, 1));
        graph.addVertex(2);
        Assert.assertEquals(List.of(), graph.getPath(1, 1));
        graph.addEdge(1, 2);
        Assert.assertEquals(List.of(), graph.getPath(1, 1));
        graph.addEdge(1, 1);
        Assert.assertEquals(List.of(), graph.getPath(1, 1));
    }

    @Test
    public void testNotConnectedSearchDirect() {
        var graph = Graphs.getUndirectedGraph(Integer.class);
        graph.addVertex(1);
        graph.addVertex(2);
        Assert.assertNull(graph.getPath(1, 2));
        graph.addEdge(1, 2);
        Assert.assertNotNull(graph.getPath(1, 2));
    }

    @Test
    public void testNotConnectedSearchIndirect() {
        var graph = Graphs.getUndirectedGraph(Integer.class);
        graph.addVertex(1);
        graph.addVertex(2);
        Assert.assertNull(graph.getPath(1, 2));
        graph.addVertex(3);
        Assert.assertNull(graph.getPath(1, 2));
        graph.addEdge(1, 3);
        Assert.assertNull(graph.getPath(1, 2));
        graph.addVertex(4);
        graph.addEdge(2, 4);
        Assert.assertNull(graph.getPath(1, 2));
        graph.addEdge(3, 4);
        Assert.assertNotNull(graph.getPath(1, 2));
    }

    @Test
    public void testSearchWithLoopsInBetween() {
        var graph = Graphs.getUndirectedGraph(Integer.class);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3, 4);
        Assert.assertNotNull(graph.getPath(1, 4));
    }

    @Test
    public void testLoopsAllowed() {
        var graph = Graphs.getUndirectedGraph(Object.class);

        var v1 = "v1";
        Assert.assertTrue(graph.addVertex(v1));

        try {
            graph.addEdge(v1, v1);
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }

    @Test
    public void testVertexAdditionUniqueness() {
        var graph = Graphs.getUndirectedGraph(Object.class);

        Assert.assertTrue(graph.addVertex(graph));
        Assert.assertFalse(graph.addVertex(graph));
        var list1 = List.of("Simple");
        var list2 = List.of("Simple");
        Assert.assertTrue(graph.addVertex(list1));
        Assert.assertFalse(graph.addVertex(list1));
        Assert.assertFalse(graph.addVertex(list2));
    }

    @Test
    public void testNullAllowed() {
        var graph = Graphs.getUndirectedGraph(Object.class);

        Assert.assertTrue(graph.addVertex(null));
        Assert.assertFalse(graph.addVertex(null));

        try {
            graph.addEdge(null, null);
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }

        try {
            Assert.assertTrue(graph.addVertex("Object"));
            graph.addEdge("Object", null);
            graph.addEdge(null, "Object");
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDuplicateEdgesAllowed() {
        var graph = Graphs.getUndirectedGraph(Object.class);

        var v1 = "v1";
        var v2 = new Object();
        Assert.assertTrue(graph.addVertex(v1));
        Assert.assertTrue(graph.addVertex(v2));

        try {
            graph.addEdge(v1, v2);
            graph.addEdge(v1, v2);
            graph.addEdge(v1, v2);
            graph.addEdge(v2, v1);
            graph.addEdge(v2, v1);
            graph.addEdge(v2, v1);
            graph.addEdge(v1, v1);
            graph.addEdge(v1, v1);
            graph.addEdge(v1, v1);
        } catch (IllegalArgumentException e) {
            Assert.fail();
        }
    }
}
