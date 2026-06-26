class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '{'){
                stack.push(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == '[' && c == ']'){
                    stack.pop();
                    continue;
                }else if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                    continue;
                }else if(stack.peek() == '{' && c == '}'){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
