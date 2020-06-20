/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemachineapplication;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author SachinVerma
 */
public class Searcher<K, T> {
    private final Map<K, T> cache;

    public Searcher(final Function<? super T, ? extends K> keyExtractor, final Collection<? extends T> items) {
        this.cache = ((Collection<T>)items).stream().collect(Collectors.toMap(keyExtractor, item -> item));
    }

    public final T search(final K key) {
        T item = cache.get(key);
        if (item == null) {
            throw new IllegalArgumentException("No item has been found for key " + key);
        }
        return item;
    }
}