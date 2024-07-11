import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt,max,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0 ,0};
	static int[] dx = {  0, 0,-1 ,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        max = 0;
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j])
					max = map[i][j];
			}            
		}
        ans = 1;
        for (int h = 0; h <= max; h++) {
            visit = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visit[i][j]) {
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
    
    static void dfs(int y, int x, int h) {
        
        visit[y][x] = true;
        
        for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			
			if(visit[ny][nx]) continue;	
			
			if(map[ny][nx] > h) {
				dfs(ny,nx,h);
			}			
		}
    }
}