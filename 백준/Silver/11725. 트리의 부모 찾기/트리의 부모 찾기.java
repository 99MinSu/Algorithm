import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parent;
	static boolean[] visit;
	static List<List<Integer>> adjList= new ArrayList<>();
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        visit = new boolean[N+1];
        
        for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
        
        for (int i = 1; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	adjList.get(a).add(b);
        	adjList.get(b).add(a);
		}
               
        dfs(1);
        
        for (int i = 2; i <= N ; i++) {
			System.out.println(parent[i]);
		}
	}
	
	static void dfs(int x) {
		visit[x] = true;
		
		for (int i : adjList.get(x)) {
			if(visit[i]) continue;
			parent[i] = x;
			dfs(i);
		}
	}
}



