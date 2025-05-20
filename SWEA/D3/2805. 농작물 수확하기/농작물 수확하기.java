import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0'; 
                }
            }

            int sum = 0;
            int mid = N / 2;

            // 다이아몬드 범위만 합산
            for (int i = 0; i < N; i++) {
                int start = Math.abs(mid - i);   // 수확 시작 열
                int end = N - start;             // 수확 끝 열

                for (int j = start; j < end; j++) {
                    sum += map[i][j];
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}