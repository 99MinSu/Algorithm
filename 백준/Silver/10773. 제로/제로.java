import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	static int K,sum;
	static Stack<Integer> st = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        K = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < K; i++) {
        	int n = Integer.parseInt(br.readLine());
        	if( n == 0) {
        		st.pop();
        	}else
    			st.push(n);
		}
        
        while( !st.isEmpty() ) {
        	sum += st.pop();
        }
        
        System.out.println(sum);

    }
}
        