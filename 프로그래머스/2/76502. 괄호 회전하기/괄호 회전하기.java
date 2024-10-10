import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i) + s.substring(0,i);
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                char c = str.charAt(j);
                
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                
                stack.push(c);
            }

            if (stack.size() == 0) {
                answer += 1;
            }
        }
        
        return answer;
    }
}