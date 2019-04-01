package Stack;

public class StackTest {
    public static void main(String[] args) throws Exception{
        Stack s = new Stack(String.class,5);

        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        //s.push("E");

        AdvanceStack as = new AdvanceStack();
        as.splitStack(s, String.class);
        System.out.println("Bottom Stack");
        as.printBottomtack();
        System.out.println("Top Stack");
        as.printTopStack();


    }


}
