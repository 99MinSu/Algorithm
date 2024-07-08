import java.io.*;
import java.util.*;

public class Main {

	static int n, allvisit; 
	static int INF = 1000000000;
	static int[][] w;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		allvisit = (1<<n) -1; // 모두 방문 했을 경우
		w = new int[n][n]; // 입력값 받을 2차원 배열 생성
		dp = new int[n][allvisit]; // dp 생성
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0,1)); // 0번도시 부터 탐색 시작 (check: 0001)
	} 
	
	static int dfs(int now, int check) {
        
		// 모든 도시 방문 완료
		if(check == allvisit) {
			if(w[now][0] == 0) return INF; // 경로 없으면 INF로 탐색 무효화 (Math.min)
			else return w[now][0]; // 경로가 존재하면 w[now][0]
		}
         
		// 이미 방문한 도시 
		if(dp[now][check] != -1) return dp[now][check];
        
		// 해당 도시에 출석 표시
		dp[now][check] = INF;
        
		// 방문하지 않은 도시 탐색 
		for(int i=0; i<n; i++) {
			// next : i 도시 방문
			int next = check | (1<<i); // or 연산을 통해 방문 체크
            
			// 경로가 없거나 i 도시를 이미 방문했을 경우 continue 
			if(w[now][i] ==0 || (check & (1<<i)) != 0) continue;
			
			dp[now][check] = Math.min(dp[now][check], dfs(i, next) + w[now][i]);
		}
		
		return dp[now][check];
	}
}