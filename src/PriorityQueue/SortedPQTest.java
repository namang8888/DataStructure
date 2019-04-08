package PriorityQueue;

/**
 * Testing Sorted PQ
 * @author Naman Gupta
 **/
public class SortedPQTest {

    public static void main(String[] args){
        SortedPriorityQueue<Integer,String> upq = new SortedPriorityQueue<Integer, String>();
        upq.insert(5,"A");
        upq.insert(9,"C");
        upq.insert(3,"B");

        SortedPriorityQueue.PQEntry<Integer,String> min = (SortedPriorityQueue.PQEntry)upq.min();
        System.out.println(min.getKey() + " --> "+ min.getValue());

        min = (SortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

        upq.insert(7,"D");

        min = (SortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

        min = (SortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

        min = (SortedPriorityQueue.PQEntry)upq.removeMin();
        System.out.println(min.getKey() + " --> "+ min.getValue() + " is removed");

    }
}
