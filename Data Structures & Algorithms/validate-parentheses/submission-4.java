class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        char k = stack.peek();
        for(int i = 1; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if (stack.isEmpty()) return false;
                k = stack.peek();
                if((c == ')' && k != '(') ||
                    (c == '}' && k != '{') ||
                    (c == ']' && k != '[')){
                    return false;
                }else{
                    stack.pop();
                }
            }        }
        return stack.isEmpty();
    }
}
