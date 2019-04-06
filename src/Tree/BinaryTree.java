package Tree;

public interface BinaryTree<E> extends Tree<E>{

    /**
     * Returns the position of the left child of p (or null if p has no left child).
     * @param p
     * @return
     */
    Position<E> left(Position<E> p) throws IllegalStateException;

    /**
     * Returns the position of the right child of p (or null if p has no right child).
     * @param p
     * @return
     */
    Position<E> right(Position<E> p) throws IllegalStateException;

    /**
     * Returns the position of the sibling of p (or null if p has no sibling).
     * @param p
     * @return
     */
    Position<E> sibling(Position<E> p) throws IllegalStateException;
}
