import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static boolean[] visit;
	static List<List<Integer>> adjList = new ArrayList<>();
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		
		for (int i = 0; i < adjList.size(); i++) {
			Collections.sort(adjList.get(i));
		}	
		
		visit = new boolean[N+1];
		
		dfs(V);
		
		System.out.println(sb1);
				
		visit = new boolean[N+1];
		
		bfs(V);
		
		System.out.println(sb2);
	}
	
	static void dfs(int x) {
		visit[x] = true;
		sb1.append(x + " ");
		for (int n : adjList.get(x)) {
			if(visit[n]) continue;
			visit[n] = true;
			dfs(n);
		}
	}
	
	static void bfs(int x) {
		q.offer(x);
		visit[x] = true;
		
		sb2.append(x + " ");
		while(!q.isEmpty()) {
			
			int n = q.poll();
			
			for (int i : adjList.get(n)) {
				if(visit[i]) continue;
					sb2.append(i + " ");
					q.offer(i);
					visit[i] = true;
			}
		}
	}
}