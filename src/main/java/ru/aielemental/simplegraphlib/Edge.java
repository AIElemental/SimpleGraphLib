package ru.aielemental.simplegraphlib;

import java.util.Optional;

/**
 * @author Artem Bulanov
 * Created at 2019-10-06
 */
public interface Edge<V> {
    boolean connects(V someSide);

    Optional<V> travel(V startPoint);
}
