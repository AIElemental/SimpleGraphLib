package ru.aielemental.tests.simplegraphlib;

import org.junit.Assert;
import org.junit.Test;
import simplegraphlib.Graphs;

/**
 * @author Artem Bulanov <aite@yandex-team.ru>
 * Created at 2019-10-06
 */
public class TestGraphs {

    @Test
    public void testPathForKnownVerticeOnly() {
        var graph = Graphs.getUndirectedGraph(Integer.class);
        try {
            graph.getPath(1, 2);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //pass
        }
        graph.addVertex(1);
        try {
            graph.getPath(1, 2);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //pass
        }
        graph.addVertex(2);
        graph.getPath(1, 2);
    }

    @Test
    public void testAddEdgeForKnownVerticeOnly() {
        var graph = Graphs.getUndirectedGraph(Integer.class);
        try {
            graph.addEdge(1, 2);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //pass
        }
        graph.addVertex(1);
        try {
            graph.addEdge(1, 2);
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //pass
        }
        graph.addVertex(2);
        graph.addEdge(1, 2);
    }
}
