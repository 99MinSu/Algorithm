import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int R,C,K,ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
        	map[i] = br.readLine().toCharArray();
		}
        visited[R-1][0] = true;
		dfs(R-1,0,1);
		System.out.println(ans);
    }
    
    static void dfs(int y, int x, int cnt) {
          	
    	if( y == 0 && x == C-1) {
        	if( cnt == K ) 
        			ans++;
        		return;     	
    	}
    	
    	for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if( nx < 0 || ny < 0 || ny >= R || nx >= C) continue;
			if(visited[ny][nx] || map[ny][nx] == 'T') continue;
	    	visited[ny][nx] = true;
			dfs(ny,nx, cnt+1);
	    	visited[ny][nx] = false;		
		}	
    }
}