/**
 * @Copyright by Naman Gupta 2019
 */
package Tree;

import java.util.Iterator;

/**
 * @author Naman Gupta
 **/
public class LinkedBinaryTreeTest {

    public static void main(String[] args){
        LinkedBinaryTree<String> lbt = new LinkedBinaryTree<String>();

        Position<String> zero = lbt.addRoot("0");
        Position<String> one = lbt.addLeft(zero,"1");
        Position<String> two = lbt.addRight(zero,"2");

        Position<String> three = lbt.addLeft(one,"3");

        Position<String> five = lbt.addLeft(two,"5");
        Position<String> six = lbt.addRight(two,"6");

        Position<String> seven = lbt.addLeft(three,"7");
        Position<String> eight = lbt.addRight(three,"8");

        Position<String> fifteen = lbt.addLeft(seven,"15");
        Position<String> sixteen = lbt.addRight(seven,"16");

        Position<String> seventeen = lbt.addLeft(eight,"17");
        Position<String> eighteen = lbt.addRight(eight,"18");

        //Iterating the tree
        System.out.println("Removing -->" + lbt.remove(one));

        Iterator<Position<String>> itr = lbt.positions().iterator();
        printTree(itr);
    }

    private static void printTree(Iterator<Position<String>> itr){
        while(itr.hasNext()){
            System.out.println(itr.next().getElement());
        }
    }

}
