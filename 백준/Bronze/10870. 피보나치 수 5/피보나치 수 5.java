import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];  //DP 배열 초기화
        
        for (int i = 0; i <= N; i++) {
        	if(i == 0) dp[0] = 0;
        	else if(i == 1) dp[1] = 1;
        	else dp[i] = dp[i-1] + dp[i-2];  //피보나치 공식 이용
        }
        System.out.print(dp[N]);
    }

    // 재귀로 푸는 법
	static int fibo(int N) {
		if (N == 0)	return 0;
		if (N == 1)	return 1;
		return fibo(N - 1) + fibo(N - 2);
	}
}
