import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N-1; i++) {
			sb.append(q.poll()+ " ");		
			q.offer(q.poll());
		}
		
		sb.append(q.poll());
		System.out.println(sb);
	}

}