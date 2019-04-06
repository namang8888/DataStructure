package Tree;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {

    /**
     * Returns the position of the root of the tree (or null if empty).
     * @return
     */
    Position<E> root();

    /**
     * Returns the position of the parent of position p (or null if p is the root).
     * @param p
     * @return
     */
    Position<E> parent(Position<E> p) throws IllegalStateException;

    /**
     * Returns an iterable collection containing the children of position p (if any).
     * @param p
     * @return
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalStateException;

    /**
     * Returns the number of children of position p.
     * @param p
     * @return
     */
    int numChildren(Position<E> p) throws IllegalStateException;

    /**
     * Returns true if position p has at least one child.
     * @param p
     * @return
     */
    boolean isInternal(Position<E> p) throws IllegalStateException;

    /**
     * Returns true if position p does not have any children.
     * @param p
     * @return
     */
    boolean isExternal(Position<E> p) throws IllegalStateException;

    /**
     * Returns true if position p is the root of the tree.
     * @param p
     * @return
     */
    boolean isRoot(Position<E> p) throws IllegalStateException;

    /**
     * Returns the number of positions (and hence elements) that are contained in the tree.
     * @return
     */
    int size();

    /**
     * Returns true if the tree does not contain any positions (and thus no elements).
     */
    boolean isEmpty();

    /**
     * Returns an iterator for all elements in the tree (so that the tree itself is Iterable).
     * @return
     */
    Iterator<E> iterator();

    /**
     * Returns an iterable collection of all positions of the tree.
     * @return
     */
    Iterable<Position<E>> positions();

}
