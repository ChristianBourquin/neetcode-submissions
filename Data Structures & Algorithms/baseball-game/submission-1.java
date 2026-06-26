class Solution {
    public int calPoints(String[] operations) {
       int sum = 0;
       Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            if(operations[i].equals("+")){
                stack.push(stack.peek() + stack.get(stack.size()-2));
                sum += stack.peek();
            }else if(operations[i].equals("D")){
                stack.push(2 * stack.peek());    
                sum += stack.peek();         
            }else if(operations[i].equals("C")){
                sum -= stack.pop();
            }else{
                stack.push(Integer.parseInt(operations[i]));
                sum += stack.peek();
            }
        }
        return sum;
    }
}