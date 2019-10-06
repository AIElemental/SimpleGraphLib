package ru.aielemental.tests.simplegraphlib;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Artem Bulanov
 * Created at 2019-10-06
 */
public class DirectedEdge<V> implements Edge<V> {
    private final V from;
    private final V to;

    public DirectedEdge(V from, V to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean connects(V someSide) {
        return Objects.equals(from, someSide) || Objects.equals(to, someSide);
    }

    @Override
    public Optional<V> travel(V startPoint) {
        if (!connects(startPoint)) {
            throw new IllegalArgumentException("Vertex not in this edge");
        }
        if (Objects.equals(from, startPoint)) {
            return Optional.of(to);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
