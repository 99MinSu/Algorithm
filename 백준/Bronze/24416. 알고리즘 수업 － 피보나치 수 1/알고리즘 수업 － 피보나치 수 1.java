import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	static int cnt,cnt2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        
        fibo(N);
        fibo2(N);
        System.out.print(cnt2+" ");
        System.out.print(cnt-1);
    }
    // 바텀업 방식
	static int fibo(int N) {
		if (N <= 1)	return N;
		
        dp = new int[N + 1];  //DP 배열 초기화
        
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= N; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        	cnt++;
		}
		return dp[N];
	}
	
	static int fibo2(int N) {
		
		if (N == 0)	return 0;
		if (N == 1)	{
			cnt2++;
			return 1;
		}
		return fibo2(N - 1) + fibo2(N - 2);
	}
}