class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String chars:tokens){
            if(chars.equals("+")){
                int b=stack.pop();
                int a=stack.pop();
                stack.push(a+b);
            }
            else if(chars.equals("-")){
                int b=stack.pop();
                int a=stack.pop();
                stack.push(a-b);
            }
            else if(chars.equals("/")){
                int b=stack.pop();
                int a=stack.pop();
                stack.push(a/b);
            }
            else if(chars.equals("*")){
                int b=stack.pop();
                int a=stack.pop();
                stack.push(a*b);
            }
           else{
            stack.push(Integer.parseInt(chars));
           }
        }
        return stack.pop();
    }
}