/**
 * @Copyright by Naman Gupta 2019
 */
package Tree;

import java.util.*;

/**
 * @author Naman Gupta
 **/
public abstract class AbstractBinaryTree<E> extends AbstractTree implements BinaryTree {

    private String traversalType = Traversal.PREORDER.getTraversalType();

    public Position sibling(Position p) throws IllegalStateException {
        Position<E> parent = parent(p);
        if(parent == null)
            return null;
        else if(left(parent) == p)
            return right(parent);
        else
            return left(parent);
    }

    public Iterable<Position<E>> children(Position p) throws IllegalStateException {
        List<Position<E>> children = new ArrayList<Position<E>>(2);

        if(left(p) != null)
            children.add(left(p));
        else if(right(p) != null)
            children.add(right(p));

        return children;
    }

    public int numChildren(Position p) throws IllegalStateException {
        int child = 0;

        if(left(p) != null)
            child++;
        else if(right(p) != null)
            child++;

        return child;
    }

    /**
     * This class adapts the iteration produced by positions to return elements.
     * @param <E>
     */
    private class ElementIterator<E> implements Iterator<E> {

        Iterator<Position<E>> positionIterator = (Iterator)positions().iterator();

        public void remove() {
            positionIterator.remove();
        }

        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        public E next() {
            return positionIterator.next().getElement();
        }
    }

    /**
     * Returns an iterator for all elements in the tree (so that the tree itself is Iterable).
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new ElementIterator<E>();
    }

    /**
     * Returns an iterable collection of all positions of the tree.
     *
     * @return
     */
    public Iterable<Position<E>> positions() {
        List<Position<E>> iterablePositions = new ArrayList<Position<E>>(size());

        if(!isEmpty()){
            if(traversalType.equals(Traversal.INORDER.getTraversalType())){
                inOrder(root(), iterablePositions);
            }else if(traversalType.equals(Traversal.PREORDER.getTraversalType())){
                preOrder(root(), iterablePositions);
            }else if(traversalType.equals(Traversal.POSTORDER.getTraversalType())){
                postOrder(root(), iterablePositions);
            }else if(traversalType.equals(Traversal.BREADTHFIRST.getTraversalType())){
                breadthFirst(root(), iterablePositions);
            }
        }

        return iterablePositions;
    }

    /**
     * Adds the Positions of the tree in list, using InOrder Traversal.
     * @param p
     * @param iterablePositions
     */
    private void inOrder(Position<E> p, List<Position<E>> iterablePositions) {

        if(left(p) != null)
            inOrder(left(p),iterablePositions);

        iterablePositions.add(p);

        if(right(p) != null)
            inOrder(right(p),iterablePositions);

    }

    /**
     * Adds the Positions of the tree in list, using PreOrder Traversal.
     * @param p
     * @param iterablePositions
     */
    private void preOrder(Position<E> p, List<Position<E>> iterablePositions) {
        iterablePositions.add(p);

        if(left(p) != null)
            preOrder(left(p),iterablePositions);

        if(right(p) != null)
            preOrder(right(p),iterablePositions);

    }

    /**
     * Adds the Positions of the tree in list, using PostOrder Traversal.
     * @param p
     * @param iterablePositions
     */
    private void postOrder(Position<E> p, List<Position<E>> iterablePositions) {
        if(left(p) != null)
            postOrder(left(p),iterablePositions);

        if(right(p) != null)
            postOrder(right(p),iterablePositions);

        iterablePositions.add(p);
    }

    /**
     * Adds the Positions of the tree in list, using Breadth First Traversal.
     * @param p
     * @param iterablePositions
     */
    private void breadthFirst(Position<E> p, List<Position<E>> iterablePositions) {
        Queue<Position<E>> queue = new LinkedList<Position<E>>();
        queue.offer(p);

        while(!queue.isEmpty()){
            Position<E> temp = queue.poll();
            iterablePositions.add(temp);

            if(left(temp) != null)
                queue.offer(left(temp));

            if(right(temp) != null)
                queue.offer(right(temp));
        }


    }

    public void setTraversalType(String traversalType) {
        this.traversalType = traversalType;
    }
}
