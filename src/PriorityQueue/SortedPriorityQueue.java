package PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * An implementation of Priority Queue with Sorted list
 * @author Naman Gupta
 **/
public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    // Collections of Priority Queue Entries
    private LinkedList<PQEntry<K,V>> entryList = new LinkedList<>();

    // Creates an Priority Queue with default comparator
    SortedPriorityQueue(){ super();}

    // Creates a Priority Queue with user's comparator
    SortedPriorityQueue(Comparator comp){ super(comp);}

    /**
     * Creates an entry with key k and value v in the priority queue.
     *
     * @param k
     * @param v
     */
    @Override
    public Entry<K, V> insert(K k, V v) throws IllegalArgumentException {
        PQEntry<K,V> pqEntry = new PQEntry<K, V>(k,v);
        Iterator<PQEntry<K,V>> itr = entryList.listIterator();
        PQEntry<K,V> walk;
        int index = 0;

        while(itr.hasNext()){
            walk = itr.next();
            if(compare(pqEntry,walk) < 0){
                break;
            }
            index++;
        }

        entryList.add(index,pqEntry);
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
        return entryList.getFirst();
    }

    /**
     * Removes and returns an entry (k,v) having minimal key from the priority queue;
     * returns null if the priority queue is empty.
     *
     * @return
     */
    @Override
    public Entry<K, V> removeMin() {
        return entryList.remove();
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
