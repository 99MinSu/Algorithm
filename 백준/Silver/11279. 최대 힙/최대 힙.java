import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	int n = Integer.parseInt(br.readLine());
			if( n != 0) {
				maxHeap.add(n);
			}else {
				if(!maxHeap.isEmpty()) {
					System.out.println(maxHeap.poll());
				}else
					System.out.println(0);
			}
		}
        
	}
}