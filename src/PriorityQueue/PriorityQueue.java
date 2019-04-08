package PriorityQueue;

/**
 * Interface for Priority Queue.
 * @author Naman Gupta
 **/
public interface PriorityQueue<K,V> {

    /**
     * Creates an entry with key k and value v in the priority queue.
     * @param k
     * @param v
     */
    Entry<K,V> insert(K k, V v) throws IllegalArgumentException;

    /**
     * Returns (but does not remove) a priority queue entry (k,v) having minimal key;
     * returns null if the priority queue is empty.
     * @return
     */
    Entry<K,V> min();

    /**
     * Removes and returns an entry (k,v) having minimal key from the priority queue;
     * returns null if the priority queue is empty.
     * @return
     */
    Entry<K,V> removeMin();

    /**
     * Returns the number of entries in the priority queue.
     * @return
     */
    int size();

    /**
     * Returns a boolean indicating whether the priority queue is empty.
     * @return
     */
    boolean isEmpty();

    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}
