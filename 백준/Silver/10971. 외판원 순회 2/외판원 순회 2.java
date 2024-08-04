import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visited;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0,0, 0);

        
        System.out.println(ans);
    }
    
    static void dfs(int start, int now, int cnt, int cost) {
    	if(cnt == n-1) {
    		if(map[now][start]> 0) {
    			cost += map[now][start];
    			ans = Math.min(ans,cost);
    		}
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
			if(start == i || visited[i] || map[now][i] <= 0) continue;
			
			visited[i] = true;
			dfs(start,i,cnt+1, cost +map[now][i]);
			visited[i] = false;
    	}
    }
}