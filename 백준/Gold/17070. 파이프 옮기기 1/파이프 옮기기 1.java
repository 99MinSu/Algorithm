import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, cnt;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(cnt);
	}
	static void dfs(int y, int x, int dir) {
		if( y == N-1 && x == N-1) {
			cnt++; return;
		}
        if(dir == 0) {
        	// 가로 방향일 경우
            if (x + 1 < N && map[y][x + 1] == 0) { // 오른쪽
                dfs(y, x + 1, 0);
            }
        }else if(dir == 1) {
        	// 세로 방향일 경우
            if (y + 1 < N && map[y + 1][x] == 0) { // 아래
            	dfs(y + 1, x, 1);
            }
		}else if(dir == 2) {
            // 대각선일 경우
            if (x + 1 < N && map[y][x + 1] == 0) { // 오른쪽 
            	dfs(y, x + 1, 0);
            }
            if (y + 1 < N && map[y + 1][x] == 0) { // 아래
            	dfs(y + 1, x, 1);
            }  
		}
 
        // 어떤 방향이든 대각선으로 이동하는 경우
        if (x + 1 < N && y + 1 < N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
        	dfs(y + 1, x + 1, 2);
        }
	}

}