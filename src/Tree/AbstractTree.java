/**
 * @Copyright by Naman Gupta 2019
 */
package Tree;

/**
 * @author Naman Gupta
 **/
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isInternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
