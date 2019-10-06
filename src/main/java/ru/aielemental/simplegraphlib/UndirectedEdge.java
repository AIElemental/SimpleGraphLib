package ru.aielemental.simplegraphlib;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * @author Artem Bulanov
 * Created at 2019-10-06
 */
public class UndirectedEdge<V> implements Edge<V> {
    private final Set<V> vertice;

    public UndirectedEdge(V v1, V v2) {
        var set = new HashSet<V>();
        set.add(v1);
        set.add(v2);
        this.vertice = Collections.unmodifiableSet(set); //Set.of() does not allow null or duplicates
    }

    @Override
    public boolean connects(V someSide) {
        return vertice.contains(someSide);
    }

    @Override
    public Optional<V> travel(V startPoint) {
        if (!connects(startPoint)) {
            throw new IllegalArgumentException("Vertex not in this edge");
        }
        for (V vertex : vertice) {
            if (!Objects.equals(vertex, startPoint)) {
                return Optional.of(vertex);
            }
        }
        return Optional.of(startPoint); //if both points are equal to startPoint, then it must be a loop.
    }

    @Override
    public String toString() {
        return "UndirectedEdge{" +
                "vertice=" + vertice +
                '}';
    }
}
