import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            for(int i = 0; i < R; i++) {
                String str = br.readLine();
                for(int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int cnt = 0;

            for(int i = 0; i < R; i++) {

                for(int j = 0; j < C; j++) {
                    if(map[i][j] == '#') {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt + "\n");

        }
        System.out.println(sb);
    }
    
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        map[r][c] = '.';

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= R || nc < 0 || nc >=C || map[nr][nc] == '.')continue;
                q.offer(new Point(nr, nc));
                map[nr][nc] = '.';
            }
        }

    }

    static class Point{
        int r, c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }

    }
}