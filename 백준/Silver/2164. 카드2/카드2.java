import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, ans;
	static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
        
        while(true) {
        	
        	if(q.size() == 1) break;
        	
        	q.poll();
        	
        	q.offer(q.poll());

        }

        
        System.out.println(q.poll());

    }
}
        