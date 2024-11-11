import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][][] map;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Node {
        int z, y, x;

        Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        q.offer(new Node(h, n, m)); // 익은 토마토 위치 큐에 저장
                    }
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        int maxDays = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 6; d++) { // 6방향 탐색
                int nz = node.z + dz[d];
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) continue;
                if (map[nz][ny][nx] == 0) { // 익지 않은 토마토
                    map[nz][ny][nx] = map[node.z][node.y][node.x] + 1;
                    q.offer(new Node(nz, ny, nx));
                }
            }
        }

        // 모든 토마토가 익었는지 확인하고 최대 일수 계산
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[h][n][m] == 0) {
                        return -1; // 익지 않은 토마토가 남아있는 경우
                    }
                    maxDays = Math.max(maxDays, map[h][n][m]);
                }
            }
        }

        // 시작이 1로 표시되었으므로 일수는 (최대값 - 1)
        return maxDays == 1 ? 0 : maxDays - 1;
    }
}
