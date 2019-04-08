package PriorityQueue;

import java.util.Comparator;

/**
 * An Abstract class to assist implementation of Priority Queue.
 * @author Naman Gupta
 **/
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    /**
     * A nested PQEntry class.
     * It has a value along with its key which will determine the priority
     * @param <K>
     * @param <V>
     */
    public static class PQEntry<K,V> implements PriorityQueue.Entry<K,V>{

        K key;
        V value;

        public PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * Default comparator that will be used in case user has not specified one
      * @param <E>
     */
    private class DefaultComparator<E> implements Comparator<E>{
        public int compare(E e1, E e2) {
            return ((Comparable<E>)e1).compareTo(e2);
        }
    }

    private Comparator comp;

    AbstractPriorityQueue(Comparator comp){
        this.comp = comp;
    }

    AbstractPriorityQueue() {
        comp = new DefaultComparator<K>();
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2){
        return comp.compare(e1.getKey(),e2.getKey());
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
