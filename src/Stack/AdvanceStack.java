package Stack;

import java.lang.reflect.Array;

public class AdvanceStack<E>{

    private E[] bottomStack;
    private E[] topStack;

    public void splitStack(Stack<E> stack, Class<E> eClass){
        E[] elements = stack.getElements();
        int top = stack.getTop();
        int splitIndex;

        if(top%2==0)
            splitIndex = top/2;//stack contains odd number of elements;
        else
            splitIndex = (top-1)/2;//stack contains even number of elements;

       bottomStack = (E[]) Array.newInstance(eClass, splitIndex+1);
       topStack = (E[]) Array.newInstance(eClass, top-splitIndex);

       for(int i = 0; i<=splitIndex; i++)
           bottomStack[i] = elements[i];

       for(int i = 0;i<=top-splitIndex-1;i++)
           topStack[i] = elements[splitIndex+i+1];
    }

    public void printBottomtack() throws Exception{
        int top = bottomStack.length;
        for(int i = top-1; i>-1; i--)
            System.out.println(bottomStack[i]);
    }

    public void printTopStack() throws Exception{
        int top = topStack.length;
        for(int i = top-1; i>-1; i--)
            System.out.println(topStack[i]);
    }


}
