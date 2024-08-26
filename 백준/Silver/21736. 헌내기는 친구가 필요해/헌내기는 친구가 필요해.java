import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, ix, iy, count;
	public static char[][] map;
	public static boolean[][] visited; 
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new char[N][M];
    	visited = new boolean[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		String s = br.readLine();
    		map[i] = s.toCharArray(); 
		}
 
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'I') {
					ix = i;
					iy = j;
				}
			}
		}
    	
    	dfs(ix,iy);
    	if(count == 0) {
    		System.out.println("TT");
    	}else
        	System.out.println(count);

    }   
    
    static void dfs(int y, int x) {
    	visited[y][x] = true;
    	
    	for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N ) continue;
			
			if(map[ny][nx] == 'X' || visited[ny][nx]) continue;
			if( map[ny][nx] == 'P') count++;
			visited[ny][nx] = true;
			dfs(ny,nx);
		}
    	
    	
    }
}