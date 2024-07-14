import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M ,R , cnt;
	static int[] visit;
	static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
       
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        visit = new int[N+1];
        
        for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine()); 
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
		}
        
        dfs(R);       
        
        for (int i = 1; i <= N; i++) {
			System.out.println(visit[i]);
		}

    }
    static void dfs(int x) {
    	visit[x] = ++cnt;
    	
    	for (int i : adjList.get(x)) {
			if(visit[i] != 0) continue;
			dfs(i);
		}
    }
}

