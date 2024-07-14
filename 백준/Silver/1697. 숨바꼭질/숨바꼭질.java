import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
       
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new int[1000001];
        
        if(N == K) {
        	System.out.println(0);
        }else{
            bfs(N);
        }
    }
    static void bfs(int x) {
    	q.offer(x);
    	visit[x] = 1;
    	
    	while(!q.isEmpty()) {
    		int temp = q.poll();
    		for (int i = 0; i < 3; i++) {
    			int next = 0;
    			if(i == 0) {
    				next = temp + 1;
    			}else if(i == 1){
    				next = temp - 1;
    			}else
    				next = 2 * temp;
                if (next == K) {
                    System.out.println(visit[temp]);
                    return;
                }
                if (next < 0 || next >= visit.length || visit[next] != 0) continue;
                q.add(next);
                visit[next] = visit[temp] + 1;
    		}  
    	}
    }
}
