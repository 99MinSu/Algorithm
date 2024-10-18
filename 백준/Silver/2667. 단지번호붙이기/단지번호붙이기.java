import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = { 0, 0,-1, 1};
    static int N, count, cnt;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                    answer.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(answer);
        System.out.println(count);

        for( int cnt : answer) {
            System.out.println(cnt);
        }
    }

    static void dfs(int y, int x){

        visited[y][x] = true;
        cnt++;

        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(map[ny][nx] == '0' || visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

}