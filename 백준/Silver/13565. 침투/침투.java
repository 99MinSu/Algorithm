import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[][] figure;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean check = false;
    static int m, n;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        figure = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                figure[i][j] = s.charAt(j) -'0';
            }
        }

        for (int i = 0; i < n; i++) {
            if (figure[0][i] == 0) {
                dfs(0, i);
            }

            if (check) {
                break;
            } else {
                visited = new boolean[m][n];
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private void dfs(int x, int y) {

        visited[x][y] = true;
        if (x == m - 1) {
            check = true;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if (!visited[nx][ny] && figure[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}