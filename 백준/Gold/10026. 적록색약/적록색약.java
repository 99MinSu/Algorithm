import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N, cnt;
    static boolean[][] visit;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 정상인 경우
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;

        // 비정상인 경우
        cnt = 0;
        visit = new boolean[N][N];
        
        // G를 R로 바꿔준다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;

        // 결과 출력
        System.out.println(normal_cnt + " " + abnormal_cnt);
    }

    static void dfs(int y, int x) {
        visit[y][x] = true;
        char currentColor = map[y][x];

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 배열 인덱스 범위 확인
            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                // 방문하지 않았고 현재 색상과 같은 경우
                if (!visit[ny][nx] && map[ny][nx] == currentColor) {
                    dfs(ny, nx);
                }
            }
        }
    }
}