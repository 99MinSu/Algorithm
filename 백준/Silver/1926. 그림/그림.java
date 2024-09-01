import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N,M,ans,cnt,size;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};	
    public static void main(String[] args) throws Exception {
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
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					size = 0;
					dfs(i,j);
				}
				ans = Math.max(ans, size);
			}
		}
        System.out.println(cnt);
        System.out.println(ans);
    }
    
    static void dfs(int y, int x) {
    	visited[y][x] = true;
    	
    	size++;
    	
    	for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if( ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if(visited[ny][nx] || map[ny][nx] != 1) continue;
			
			visited[ny][nx] = true;
			dfs(ny, nx);
		}
    }
}