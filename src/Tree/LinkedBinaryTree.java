package Tree;

import java.util.*;
import java.util.function.Consumer;

/**
 * Linked representation of the Binary Tree. In this each node
 * has reference to its childs.
 * It extends AbstractBinaryTree class.
 * @author Naman Gupta
 **/
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected Node<E> root = null;
    private int size = 0;


    protected static class Node<E> implements Position<E>{

        private E element;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;

        public Node(E element, Node<E> left, Node<E> right, Node<E> parent) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E e) {
            this.element = e;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }

    protected Node<E> createNode(E element, Node<E> left, Node<E> right, Node<E> parent){
        return new Node<E>(element,left,right,parent);
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
        if(node.getParent() == node)
            throw new IllegalArgumentException("Position is no longer in the Tree");

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
        return node.getLeft();
    }

    /**
     * Returns the position of the right child of p (or null if p has no right child).
     *
     * @param p
     * @return
     */
    public Position right(Position p) throws IllegalStateException {
        Node<E> node = validate(p);
        return node.getRight();
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
     * Returns the number of positions (and hence elements) that are contained in the tree.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Returns the position of the parent of position p (or null if p is the root).
     *
     * @param p
     * @return
     */
    public Position parent(Position p) throws IllegalStateException {
        Node<E> node = validate(p);
        return node.getParent();
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
        root = createNode(e,null,null,null);
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
        Node<E> node = createNode(e,null,null,parent);
        parent.setLeft(node);
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
        Node<E> node = createNode(e,null,null,parent);
        parent.setRight(node);
        size++;
        return node;
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
     * Attaches the internal structure of trees T1 and T2 as the respective left
     * and right subtrees of leaf position p and resets T1 and T2 to empty trees;
     * an error condition occurs if p is not a leaf.
     * @param p
     * @param t1
     * @param t2
     * @throws IllegalArgumentException
     */
    public void attach(Position p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
        if(isInternal(p))
            throw new IllegalArgumentException("P must be a leaf");

        Node<E> parent = validate(p);
        size += t1.size + t2.size;

        if(!t1.isEmpty()){
           parent.setLeft(validate(t1.root));
           t1.root.setParent(parent);
           t1.size = 0;
           t1.root = null;
        }

        if(!t2.isEmpty()){
            parent.setRight(validate(t2.root));
            t2.root.setParent(parent);
            t2.size = 0;
            t2.root = null;
        }
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

        Node<E> parentNode = node.parent;
        Node<E> childNode = node.getLeft() != null ? node.getLeft() : node.getRight();

        childNode.setParent(parentNode);

        if(node == root){
            root = childNode;
        }else {
            if(parentNode.getLeft() == node){
                parentNode.setLeft(childNode);
            } else if(parentNode.getRight() == node){
                parentNode.setRight(childNode);
            }
            size--;
        }

        node.setParent(node);
        return node.getElement();
    }
}
