import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,cnt1, cnt2,ans1,ans2;
	static int dy[]= {-1,1,0,0};
	static int dx[]= {0,0,-1,1};
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) { // 방문하지 않았을 때 들어간다.
					dfs(i,j, map[i][j]); // dfs 시작
					ans1 += cnt1 * cnt1; // W cnt1 가져온거 곱해줌 N2의 위력
					ans2 += cnt2 * cnt2; // H cnt1 가져온거 곱해줌 N2의 위력
					
					// 다시 시작하기전에 카운트 초기화
					cnt1 = 0; 
					cnt2 = 0;
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}

	private static void dfs(int y, int x, char c) {
		
		visited[y][x] = true; // 현재 위치 방문 체크
		
		if(c == 'W') { // W이면 w cnt1 증가
			cnt1++;
		}else {
			cnt2++; // B이면 w cnt2 증가
		}
		
		for (int d = 0; d < 4; d++) {  // 상하좌우 방향백터 사용
			int ny = y+dy[d];	
			int nx = x+dx[d];   
				
			if(nx<0 || ny<0 || nx>=M || ny>=N) continue; // 범위 벗어나면 넘어감
			
			if(visited[ny][nx] || map[ny][nx] != c) continue; // 이미 방문했거나 들어온 색과 다르면 넘어감 (같은 색으로만 갈 수 있기 때문에)
			dfs(ny,nx, c); // 움직인 위치와 가져온 색 넣어줌
		}
	}
}