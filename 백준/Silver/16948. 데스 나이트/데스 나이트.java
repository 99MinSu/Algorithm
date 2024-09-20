import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,r1,c1,r2,c2;
	static int dy[]= {-2,-2, 0, 0, 2, 2};
	static int dx[]= {-1, 1,-2, 2,-1, 1};
	static int[][] map;
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		map = new int[N][N]; 
		
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = -1;
            }
        }
		
		bfs(r1,c1);
		System.out.println(map[r2][c2]);
	}

	static void bfs(int y, int x) {
				
        q.offer(new int[]{y, x});
        while (!q.isEmpty()) {
        	
            int[] knight = q.poll();
            map[y][x] = 0;
            
            for (int i = 0; i < 6; i++) { 
                int ny = knight[0] + dy[i];
                int nx = knight[1] + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == -1) {
                    map[ny][nx] = map[knight[0]][knight[1]] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
	}
}