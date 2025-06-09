import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            String str = s.substring(i) + s.substring(0,i); // 돌려돌려
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                char c = str.charAt(j);
                
                if (stack.isEmpty()) { // 비어있으면 일단 넣는다
                    stack.push(c);
                    continue;
                }
                
                // 괄호마다 한 쌍일 때 꺼낸다
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
                
                stack.push(c); // 아니면 푸쉬푸쉬
            }

            if (stack.size() == 0) {
                answer += 1;
            }
        }
        
        return answer;
    }
}