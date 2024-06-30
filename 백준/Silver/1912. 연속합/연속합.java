import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 n 읽기
        int n = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 수열 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 동적 계획법을 위한 배열 선언 및 초기화
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];
        
        // 동적 계획법을 통해 최대 연속 부분합 계산
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        
        // 결과 출력
        System.out.println(max);
    }
}