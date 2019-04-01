/**
 * @Copyright by Naman Gupta 2019
 */
package Polynomials;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Naman Gupta
 **/
public class AddPolynomials {

    private static LinkedList<Node> addPoly(LinkedList<Node> first, LinkedList<Node> second){
        LinkedList<Node> finalPoly = new LinkedList<>();

        ListIterator<Node> a = first.listIterator(0);
        ListIterator<Node> b = second.listIterator(0);

        Node ai = a.next();
        Node bi = b.next();
        while(ai != null && bi != null){
            Node newNode;

            if(ai.getExpo() == bi.getExpo()){
                newNode = new Node(ai.getCoef()+bi.getCoef(),ai.getExpo());
                finalPoly.addLast(newNode);
                ai = moveCursorToNext(a);
                bi = moveCursorToNext(b);
            }else if(ai.getExpo() < bi.getExpo()){
                finalPoly.addLast(bi);
                bi = moveCursorToNext(b);
            } else if (ai.getExpo() > bi.getExpo()){
                finalPoly.addLast(ai);
                ai = moveCursorToNext(a);
            }
        }

        if(ai == null){
            while(bi != null){
                finalPoly.addLast(bi);
                bi = moveCursorToNext(b);
            }
        }

        if(bi == null){
            while(ai!= null){
                finalPoly.addLast(ai);
                ai = moveCursorToNext(a);
            }
        }

        return finalPoly;
    }

    public static Node moveCursorToNext(ListIterator<Node> itr){
        return itr.hasNext() ? itr.next() : null;
    }

    public static void main(String[] args){
        LinkedList<Node> first = new LinkedList<>();

        Node f1 = new Node(3,14);first.addLast(f1);
        Node f2 = new Node(2,8);first.addLast(f2);
        Node f3 = new Node(1,0);first.addLast(f3);

        LinkedList<Node> second = new LinkedList<>();

        Node s1 = new Node(8,14);second.addLast(s1);
        Node s2 = new Node(3,10);second.addLast(s2);
        Node s3 = new Node(10,6);second.addLast(s3);

        LinkedList<Node> finalResult = addPoly(first,second);

        ListIterator<Node> finalItr = finalResult.listIterator();
        while(finalItr.hasNext()){
            System.out.println(finalItr.next());
        }


    }
}
