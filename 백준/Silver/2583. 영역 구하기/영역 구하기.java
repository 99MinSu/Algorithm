import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M,N,K,cnt,ans;
	static List<Integer> list = new ArrayList<>();
	static int[][] map;
	static int[] dy = {-1,1, 0,0};
	static int[] dx = { 0,0,-1,1};
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
       
        map = new int[M][N];
        
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	for (int j = y1; j < y2 ; j++) {
				for (int j2 = x1; j2 < x2; j2++) {
					map[j][j2] = 1;
				}
			}
		}

        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					ans++;
					dfs(i,j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
        Collections.sort(list);
        
        System.out.println(ans);
        for (int i = 0; i < ans; i++) {
			System.out.print(list.get(i)+" ");
		}
        
	}
	
	static void dfs(int y, int x) {
		map[y][x] = 1;
		cnt++;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= M || nx >= N ) continue;
			if(map[ny][nx] == 1)continue;
			
			map[ny][nx] = 1;
			dfs(ny,nx);
		}
	}
}


