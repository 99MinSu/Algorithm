import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	public static int N, M, ans;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {0,0,-1,1,-1,1 ,-1,1};
	public static int[] dy = {-1,1,0,0,-1,-1 ,1,1};
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	visited = new boolean[N][M];
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if( map[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
					ans++;
				}
			}
		}
    	System.out.println(ans);
    }
    
    static void dfs(int y, int x) {
    	visited[y][x] = true;
    	
    	for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if(visited[ny][nx] || map[ny][nx] == 0) continue;
			dfs(ny,nx);
		}
    }
}