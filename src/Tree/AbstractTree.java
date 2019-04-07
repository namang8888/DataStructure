package Tree;

/**
 * An abstract class that represents a generic tree.
 * All those classes that represents a tree would have to extends this class.
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
