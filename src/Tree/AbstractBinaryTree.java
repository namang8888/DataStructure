/**
 * @Copyright by Naman Gupta 2019
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Naman Gupta
 **/
public abstract class AbstractBinaryTree<E> extends AbstractTree implements BinaryTree {

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
}
