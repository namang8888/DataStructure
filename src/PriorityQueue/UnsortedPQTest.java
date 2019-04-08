package PriorityQueue;

/**
 * Testing Unsorted PQ
 * @author Naman Gupta
 **/
public class UnsortedPQTest {

    public static void main(String[] args){
        UnsortedPriorityQueue<Integer,String> upq = new UnsortedPriorityQueue<Integer, String>();
        upq.insert(5,"A");
        upq.insert(9,"C");
        upq.insert(3,"B");

        UnsortedPriorityQueue.PQEntry<Integer,String> min = (UnsortedPriorityQueue.PQEntry)upq.min();
        System.out.println(min.getKey() + " --> "+ min.getValue());

        min = (UnsortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

        upq.insert(7,"D");

        min = (UnsortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

        min = (UnsortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

        min = (UnsortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

    }
}
