package com.asdt.farm;

/**
 *
 * @param <T> You can observe anything and use as parameter anything. T = integer here
 */
public interface Observer<T> {
    void inform(T current);
}
