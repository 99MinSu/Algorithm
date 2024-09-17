import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,cnt1,cnt2,ans1,ans2;
	static int dy[]= {-1,1,0,0};
	static int dx[]= {0,0,-1,1};
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j] && map[i][j] != '#') {
					dfs(i,j);					
					if(cnt2 > cnt1) { // 양이 늑대보다 더 많으면
						ans2 += cnt2; // 늑대 죽음 양만 플러스
					}else {
						ans1 += cnt1; // 양 죽음 늑대만 플러스
					}
				}
				// 늑대 양 둘 다 초기화
				cnt1 = 0;
				cnt2 = 0;
			}
		}
		System.out.println(ans2 + " " + ans1);
	}

	static void dfs(int y, int x) {
		
		visited[y][x] = true;
		
		if( map[y][x] == 'v' ) {
			cnt1++; // 늑대
		}else if(map[y][x] == 'k') {
			cnt2++; // 양
		}
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0|| ny >= R || nx >= C) continue;
			if(visited[ny][nx] || map[ny][nx] == '#') continue;
			dfs(ny,nx);
		}
	}
}