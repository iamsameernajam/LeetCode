import java.util.Stack; // Import the Stack class

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i]; 
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                int num2 = stk.pop(); 
                int num1 = stk.pop(); 

                int result;
                if (token.equals("+")) {
                    result = num1 + num2;
                } else if (token.equals("-")) {
                    result = num1 - num2; 
                } else if (token.equals("*")) {
                    result = num1 * num2;
                } else { 
                    result = num1 / num2;
                }
                stk.push(result);
            } else {
                stk.push(Integer.parseInt(token)); 
            }
        }
        return stk.pop();
    }
}