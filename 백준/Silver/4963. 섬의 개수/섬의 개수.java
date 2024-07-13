import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h, cnt;
	static int[][] map;	
	static int[] dy = {-1,1, 0,0,-1,1,-1,1};
	static int[] dx = { 0,0,-1,1,-1,-1,1,1};
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if( w == 0 && h == 0) break;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            cnt = 0;
            for (int i = 0; i < h; i++) {
				for (int j = 0; j< w ;j++) {
					if(map[i][j] == 1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
            System.out.println(cnt);
            
        }
    }
    static void dfs(int y, int x) {
    	map[y][x] = 0;
    	
    	for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >=  h|| nx >= w) continue;
			
			if(map[ny][nx] == 0) continue;
			
			map[ny][nx] = 0;
			dfs(ny, nx);
		}
    }
}

