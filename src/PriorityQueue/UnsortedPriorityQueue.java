package PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * An implementation of Priority Queue with Unsorted list
 * @author Naman Gupta
 **/
public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    // Collections of Priority Queue Entries
    private LinkedList<PQEntry<K,V>> entryList = new LinkedList<>();

    // Creates an Priority Queue with default comparator
    UnsortedPriorityQueue(){ super();}

    // Creates a Priority Queue with user's comparator
    UnsortedPriorityQueue(Comparator comp){ super(comp);}

    /**
     * Creates an entry with key k and value v in the priority queue.
     *
     * @param k
     * @param v
     */
    @Override
    public Entry<K,V> insert(K k, V v) throws IllegalArgumentException {
        PQEntry<K,V> pqEntry = new PQEntry<K, V>(k,v);
        entryList.add(pqEntry);

        return pqEntry;
    }

    /**
     * Returns (but does not remove) a priority queue entry (k,v) having minimal key;
     * returns null if the priority queue is empty.
     *
     * @return
     */
    @Override
    public Entry<K, V> min() {
        if(isEmpty()){
            return null;
        }

        PQEntry<K,V> small = entryList.getFirst();

        for(PQEntry<K,V> entry : entryList){
            if(compare(entry, small) < 0){
                small = entry;
            }
        }

        return small;
    }

    /**
     * Removes and returns an entry (k,v) having minimal key from the priority queue;
     * returns null if the priority queue is empty.
     *
     * @return
     */
    @Override
    public Entry<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }

        PQEntry<K,V> small = (PQEntry<K,V>)min();
        entryList.remove(small);
        return small;
    }

    /**
     * Returns the number of entries in the priority queue.
     *
     * @return
     */
    @Override
    public int size() {
        return entryList.size();
    }

    public LinkedList<PQEntry<K, V>> getEntryList() {
        return entryList;
    }
}
