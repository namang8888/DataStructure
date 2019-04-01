package Stack;

import java.lang.reflect.Array;

public class Stack<E> {

    private E[] elements;

    private int top;
    private int capacity;

    Stack(Class<E> c,int capacity){
        elements = (E[]) Array.newInstance(c, capacity);
        top = -1; // indicating that stack is empty at the start
        this.capacity = capacity;
    }

    // Check if Stack is Empty
    public boolean isEmpty(){
       return top == -1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    // Returns the top element of the Stack
    public E top() throws Exception{
       if(isEmpty())
            throw new Exception("Stack is Empty");

        return elements[top];
    }

    //Insert a new Element
    public void push(E newElement) throws Exception{
        if(isFull())
            throw new Exception("Stack is Full");

        top++;
        elements[top] = newElement;
    }

    //Remove the Element
    public E pop() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty");

        E topElement = elements[top];
        elements[top] = null;
        top--;
        return topElement;
    }

    public void printStack() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty");

        for(int i = top; i>-1; i--)
            System.out.println(elements[i]);
    }

    public E[] getElements() {
        return elements;
    }

    public int getTop() {
        return top;
    }

    public int getCapacity() {
        return capacity;
    }
}
