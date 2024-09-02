import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,K,ans1,ans2, cnt1,cnt2;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#') {
					cnt1 = 0;
					cnt2 = 0;
					dfs(i,j);
					if(!(cnt1 == 0 && cnt2 == 0)) {
						if(cnt1 >= cnt2) {
							ans1 += cnt1;
						}else if(cnt1 < cnt2)
							ans2 += cnt2;
					}
				}
			}
		}
		System.out.println(ans2 + " " + ans1);
		
	}

	private static void dfs(int x, int y) {

		if(map[x][y] == 'v') cnt1++;
		if(map[x][y] == 'o') cnt2++;
		
		map[x][y] = '#';
		
		for (int k = 0; k < 4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C)continue;
			if(map[nx][ny] == '#') continue;
			dfs(nx,ny);
		}
	}
}