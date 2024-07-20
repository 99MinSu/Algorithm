import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];  //DP 배열 초기화
                
        System.out.print(fibo(N));
    }
    // 탑다운 방식
	static int fibo(int N) {
		if (N <= 1)	return N;
		if (dp[N] != 0)	return dp[N]; // 메모이제이션
		
		dp[N] = fibo(N-1) + fibo(N-2);
		return dp[N];
	}
}