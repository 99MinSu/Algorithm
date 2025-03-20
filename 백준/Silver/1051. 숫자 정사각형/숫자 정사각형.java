import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 정사각형인지 검사
                ans = Math.max(ans, sqare(i, j));
            }
        }
        if (ans == 0)
            ans = 1;
        System.out.println(ans);

    }

    private static int sqare(int i, int j) {
        int max = 0;
        for (int k = 1; k < N; k++) {
            if (i + k < N && j + k < M) {
                if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
                    max = Math.max(max, (k + 1) * (k + 1));
                }
            }
        }
        return max;
    }
}