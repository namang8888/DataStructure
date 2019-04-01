package ExpressionEvaluation;

import java.util.Stack;
import java.util.StringTokenizer;

public class Expressiosn {

    public static int evaluate(String expression){
        StringTokenizer tokens = new StringTokenizer(expression);
        int finalResult;
        Stack<Integer> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        while(tokens.hasMoreTokens()){
            String nextToken = tokens.nextToken();

            boolean isNumeric = true;
            try{
                Integer.parseInt(nextToken);
            } catch (NumberFormatException e){
                isNumeric = false;
            }

            if(isNumeric){
                operands.push(Integer.parseInt(nextToken));
            } else if (nextToken.equals(")")){
                while(!operators.peek().equals("(")){
                   int result = performOperation(operators.pop(),operands.pop(),operands.pop());
                   operands.push(result);
                }
                operators.pop();
            } else {
                if(!checkPrecedence(operators,nextToken)){
                    int result = performOperation(operators.pop(),operands.pop(),operands.pop());
                    operands.push(result);
                } else{
                    operators.push(nextToken);
                }
            }
        }

        while(!operators.empty()){
            int result =  performOperation(operators.pop(),operands.pop(),operands.pop());
            operands.push(result);
        }


        return operands.pop();
    }

    private static boolean checkPrecedence(Stack<String> operators,String op2){
       if(operators.empty())
           return true;

        String op1 = operators.peek();

        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-")))
            return false;
        else
            return true;

    }

    private static int performOperation(String operator, int a, int b){
        switch(operator){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if(b == 0) throw new UnsupportedOperationException();
                return a / b;
        }
        return 0;
     }

     public static void main(String[] args){
         System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
     }
}
