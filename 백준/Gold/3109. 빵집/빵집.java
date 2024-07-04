import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C,cnt;
	static char[][] map;
	static int dy[] = { -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][];
        
        for (int i = 0; i < R; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        			
        for (int i = 0; i < R; i++) {
			if(dfs(i,0)) cnt++;
		}
        
        System.out.println(cnt);
        
    }
    static boolean dfs(int y, int x) {
    	int nx = x + 1;
    	
    	if( nx == C-1) return true;
    	
    	for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
		    if( ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
        	map[ny][nx] = 'x';     
        	if(dfs(ny,nx))return true;	
		}
    	return false;
    }
}

