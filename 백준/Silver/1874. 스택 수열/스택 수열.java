import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int T;
	static StringBuilder sb = new StringBuilder();
	static int temp = 1;
	static boolean err = false;	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();

		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			
			for (int j = temp; j <= N; j++) {
				stack.push(j);
				sb.append("+").append("\n");
				temp = j + 1;
			}
			if(stack.peek()==N) {
				stack.pop();
				sb.append("-").append("\n");
			}else {
				err = true;
			}
		}
		
		if(err)
			System.out.println("NO");
		else
			System.out.println(sb);
	}
}   