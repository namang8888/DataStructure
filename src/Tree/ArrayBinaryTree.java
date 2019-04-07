package Tree;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Array representation of the Binary Tree.
 * Each node only has the index where it is stored.
 * It extends AbstractBinaryTree class.
 * @author Naman Gupta
 **/
public class ArrayBinaryTree<E> extends AbstractBinaryTree<E> {

    private Node<E>[] dataArray;
    private Node<E> root;
    private int size = 0;
    private int arraySize = 10;

    protected static class Node<E> implements Position<E>{
        private E element;
        private int index;

        public Node(E element, int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public E getElement() {
            return element;
        }

        @Override
        public void setElement(E element) {
            this.element = element;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public ArrayBinaryTree() {
        dataArray = (Node<E>[])Array.newInstance(Node.class,arraySize);
    }

    protected Node<E> createNode(E element, int index){
        return new Node<E>(element,index);
    }

    /**
     * Validates the Position and return it as a Node
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid Position");

        Node<E> node = (Node<E>)p;

        return node;
    }

    /**
     * Returns the position of the left child of p (or null if p has no left child).
     *
     * @param p
     * @return
     */
    public Position left(Position p) throws IllegalStateException {
        Node<E> node = validate(p);
        int leftIndex = getLeftIndex(node.getIndex());

        if(leftIndex+1 > arraySize)
            resize();

        return dataArray[leftIndex];
    }

    /**
     * Returns the position of the right child of p (or null if p has no right child).
     *
     * @param p
     * @return
     */
    public Position right(Position p) throws IllegalStateException {
        Node<E> node = validate(p);
        int rightIndex = getRightIndex(node.getIndex());

        if(rightIndex+1 > arraySize)
            resize();

        return dataArray[rightIndex];
    }

    /**
     * Calculates the left index of a given parent index.
     * @param parentIndex
     * @return
     */
    private int getLeftIndex(int parentIndex){
        return 2*(parentIndex) + 1;
    }

    /**
     * Calculates the right index of a given parent index.
     * @param parentIndex
     * @return
     */
    private int getRightIndex(int parentIndex){
        return 2*(parentIndex + 1);
    }

    /**
     * Returns the position of the root of the tree (or null if empty).
     *
     * @return
     */
    public Position root() {
        return root;
    }

    /**
     * Returns the position of the parent of position p (or null if p is the root).
     *
     * @param p
     * @return
     */
    public Position parent(Position p) throws IllegalStateException {
        Node<E> node = validate(p);

        if(root == node){
            return null;
        }

        int pIndex = node.getIndex();
        int parentIndex = 0;

        if((pIndex % 2) == 0){
            // it is a right child of its parent
            parentIndex = (pIndex - 2)/2;
        } else {
            // It is a left child of its parent
            parentIndex = (pIndex - 1) / 2;
        }

        return dataArray[parentIndex];
    }

    /**
     * Returns the number of positions (and hence elements) that are contained in the tree.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Creates a root for an empty tree, storing e as the element,
     * and returns the position of that root; an error occurs if the tree is not empty.
     * @param e
     * @return
     * @throws IllegalStateException
     */
    public Position<E> addRoot(E e) throws IllegalStateException{
        if(!isEmpty())
            throw new IllegalStateException("Invalid Operation. Tree already has a root");
        size++;
        root = createNode(e,0);
        dataArray[0] = root;
        return root;
    }

    /**
     * Creates a left child of position p, storing element e,
     * and returns the position of the new node; an error occurs if p already has a left child.
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        if(left(p) != null)
            throw new IllegalArgumentException("Position already has left child");

        Node<E> parent = validate(p);
        int index = getLeftIndex(parent.getIndex());

        if(index + 1 > arraySize)
            resize();

        Node<E> node = createNode(e,index);
        dataArray[index] = node;
        size++;
        return node;
    }

    /**
     * Creates aright child of position p, storing element e,
     * and returns the position of the new node; an error occurs if p already has a right child.
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
        if(right(p) != null)
            throw new IllegalArgumentException("Position already has right child");

        Node<E> parent = validate(p);
        int index = getRightIndex(parent.getIndex());

        if(index + 1 > arraySize)
            resize();

        Node<E> node = createNode(e,index);
        dataArray[index] = node;
        size++;
        return node;
    }

    private void resize(){
        int newArraySize = 2*arraySize;
        Node<E>[] newDataArray = (Node<E>[])Array.newInstance(Node.class,newArraySize);

        for(int i = 0; i<arraySize; i++)
            newDataArray[i] = dataArray[i];

        arraySize = newArraySize;
        dataArray = newDataArray;
    }

    /**
     * Replaces the element stored at position p with element e, and returns the previously stored element.
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);

        E previous = parent.getElement();
        parent.setElement(e);

        return previous;
    }

    /**
     * Removes the node at position p, replacing it with its child (if any),
     * and returns the element that had been stored at p; an error occurs if p has two children.
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if(numChildren(p) == 2)
            throw new IllegalArgumentException("Position has 2 childeren");

        Node<E> parentNode = (Node)parent(p);
        Node<E> childNode;

        if(left(p) != null)
            childNode = (Node)left(p);
        else
            childNode = (Node)right(p);

        Queue<Node<E>> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        nodeQueue.offer(childNode);
        indexQueue.offer(parentNode.getIndex());

        while(!nodeQueue.isEmpty()){
            Node<E> tempNode = nodeQueue.poll();
            int parentIndex = indexQueue.poll();
            int oldIndex = tempNode.getIndex();
            int newIndex;

            if(isInternal(tempNode)){
                if(left(tempNode) != null)
                    nodeQueue.offer((Node<E>)left(tempNode));

                if(right(tempNode) != null)
                    nodeQueue.offer((Node<E>)right(tempNode));
            }
            if((oldIndex % 2) == 0)
                newIndex = getRightIndex(parentIndex);
            else
                newIndex = getLeftIndex(parentIndex);

            tempNode.setIndex(newIndex);
            dataArray[newIndex] = dataArray[oldIndex];
            dataArray[oldIndex] = null;
            indexQueue.offer(newIndex);
            indexQueue.offer(newIndex);
        }

        size--;

        return node.getElement();
    }
}
