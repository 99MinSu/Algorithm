import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,V;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit; // 중복 방문 방지
    static boolean[][] matrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N + 1; i++) { // 0 dummy 
			adjList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList.get(n1).add(n2); 
			adjList.get(n2).add(n1); // 양방향!!!!!!!!!!!!!!!!
		}
		
        for (int i = 0; i < adjList.size(); i++) { // 여러 개인 경우 작은 것부터 방문하기 위해 정렬
            Collections.sort(adjList.get(i)); 
        }
        
		visit = new boolean[N + 1];
		
		dfs(V);
		System.out.println();
		
		for (int i = 0; i < N + 1; i++) {
			visit[i] = false;
		}
		
		bfs(V);
	}
	
    static void bfs(int n) { // n : 시작 정점
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        visit[n] = true;
        
        while(! queue.isEmpty() ) {
            // 정점을 꺼낸다.
            int v = queue.poll();
            
            // 필요한 처리 수행
            System.out.print(v + " ");
            
            // 계속 방문을 이어 간다.
            List<Integer> list = adjList.get(v);
            for (Integer i : list) {
				if( visit[i] ) continue;
                queue.offer(i);
                visit[i] = true;
			}                     
        }
    }
    
    // stack 대신 동일한 효과 더 편한 재귀 호출을 이용
    static void dfs(int n) { // n : 시작 정점
        visit[n] = true;
        
        // 필요한 처리 수행
        System.out.print(n + " ");
        
        // 계속 방문을 이어 간다.
        List<Integer> list = adjList.get(n);
        for (Integer i : list) {
			if( visit[i] ) continue;
            dfs(i);
		}         
    }
	    
	        // 자료구조
//	        matrix = new boolean[N+1][N+1]; // 0 dummy
//	        
//	        for (int i = 0; i < M; i++) {
//				st = new StringTokenizer(br.readLine());
//				int n1 = Integer.parseInt(st.nextToken());
//				int n2 = Integer.parseInt(st.nextToken());
//				matrix[n1][n2] = true;
// 				matrix[n2][n1] = true;
//			}
//	        
//	        visit = new boolean[N+1];
//	        
//     	    bfs(V);
//	        System.out.println();
//			for (int i = 0; i < N + 1; i++) {
//				visit[i] = false;
//		    }
//			
//	        dfs(V);
//	    }
//	
//	    static void bfs(int n) { // n : 시작 정점
//	        Queue<Integer> queue = new ArrayDeque<>();
//	        queue.offer(n);
//	        visit[n] = true;
//	        
//	        while(! queue.isEmpty() ) {
//	            // 정점을 꺼낸다.
//	            int v = queue.poll();
//	            
//	            // 필요한 처리 수행
//	            System.out.print(v + " ");
//	            
//	            // 계속 방문을 이어 간다.
//	            for (int i = 1; i <= 4; i++) {
//	                if( ! matrix[v][i] || visit[i] ) continue;
//	                queue.offer(i);
//	                visit[i] = true;
//	            }
//	            
//	        }
//	    }
//	    
//	    // stack 대신 동일한 효과 더 편한 재귀 호출을 이용
//	    static void dfs(int n) { // n : 시작 정점
//	        visit[n] = true;
//	        
//	        // 필요한 처리 수행
//	        System.out.print(n + " ");
//	        
//	        // 계속 방문을 이어 간다.
//	        for (int i = 1; i <= 4; i++) {
//	            if( ! matrix[n][i] || visit[i] ) continue;
//	            dfs(i);
//	        }       
//	    }
}