import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String input = st.nextToken();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < len; i++) {
                char c = input.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop(); 
                } else {
                    stack.push(c); 
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }

            System.out.println("#" + tc + " " + sb.toString());
        }
    }
}