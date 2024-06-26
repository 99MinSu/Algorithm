import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    // 정점 1, 2, 3, 4
    // 연결 정보
    // 1 -> 2, 4
    // 2 -> 3, 4
    // 3 -> 2
    // 4 -> 3
    static boolean[] visit; // 중복 방문 방지
    static int max, N , M;
	static ArrayList <Integer>[] array;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        // 자료구조
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	visit = new boolean[N+1];
        arr = new int[N+1];

    	array = new ArrayList[N+1];
    	for (int i = 0; i < N+1; i++) { // 0 dummy list
			array[i] = new ArrayList<Integer>(); // 0, 1, 2, 3, 4 ArrayList 객체가 만들어 진다.
		}
    	
    	for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			array[a].add(b);
		}
                       
        
        for (int i = 1; i <= N ; i++) {
        	visit = new boolean[N+1];
        	bfs(i);	
		}

        for (int i = 1; i <= N; i++) {
        	if(arr[i] > max) {
        		max = arr[i];
        	}
		}
        
        for (int i = 1; i <= N; i++) {
        	if(arr[i] == max) {
        		System.out.print(i+" ");
        	}
		}

          
    }
    
    static void bfs(int n) { // n : 시작 정점
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visit[n] = true;
        
        while(! queue.isEmpty() ) {
            // 정점을 꺼낸다.
            int v = queue.poll();

            for (int i : array[v]) {
            	if( visit[i] ) continue;
            	arr[i]++;
                visit[i] = true;
                queue.add(i);
			}                     
        }
    }
}