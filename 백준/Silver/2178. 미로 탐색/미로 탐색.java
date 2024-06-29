import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int N, M, count;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dy = { -1, 1, 0 , 0};
    static int[] dx = { 0,  0, -1, 1};
    static class Node{
    	int y, x;
    	Node(int y, int x){
    		this.y = y;
    		this.x = x;
    	}
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visit = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
        	String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] =  s.charAt(j) - '0';
			}
		}
        
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }
    
    static void bfs(int y, int x) {
    	q.offer(new Node(y,x));
    	visit[y][x] = true;

    	while (!q.isEmpty()) {
    		Node node = q.poll();
    		for (int d = 0; d < 4; d++) {
    			int ny = node.y + dy[d];
    			int nx = node.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if (visit[ny][nx] || map[ny][nx] == 0) continue;
				
				q.offer(new Node(ny,nx));
				map[ny][nx] = map[node.y][node.x] + 1;
				visit[ny][nx] = true;

			}
    		
    	}
    }
}