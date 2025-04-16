import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();   
    
        for (int i=0;i<carr.length;i++) {
            char c = carr[i];
            // 스택이 비어있다면 현재 문자는 반복될 일이 없으므로 push
            if (stack.isEmpty()) stack.push(c);
            // 스택이 비어있지 않다면
            else {

                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }        
        // 스택에 남아있는 값들은 반복되지 않는 값들임 즉, 비어있어다면 모두 짝지어 반복된 것
        return stack.isEmpty() ? 1 : 0;
    }
}