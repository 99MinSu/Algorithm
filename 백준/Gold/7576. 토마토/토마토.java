import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxDays;
    static int[][] map;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
                if (map[ny][nx] == 0) {
                    map[ny][nx] = map[node.y][node.x] + 1;
                    q.offer(new Node(ny, nx));
                }
            }
        }
        
        maxDays = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return - 1;
                }
                maxDays = Math.max(maxDays, map[i][j]);
            }
        }
        
        if (maxDays == 1) {
            return 0;
        } else { // 아닐 경우 최종날짜 - 1 출력
            return maxDays-1;
        }
    }
    
}