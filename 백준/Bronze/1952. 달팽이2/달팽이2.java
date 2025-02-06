import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];

        int answer = 0;
        int count = 1;
        int dir = 0;
        int x = 0, y = 0;
        map[x][y] = 1;

        while (count != N * M) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] != 1) {
                
                x = nx;
                y = ny;
                
                count++;
                map[x][y] = 1;

            } else {
                dir = (dir + 1) % 4;
                answer++;
            }

        }
        System.out.println(answer);

    }

}