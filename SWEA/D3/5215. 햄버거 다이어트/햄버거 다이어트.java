import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static int N, L, max;
	static int[] sc, cal;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());		
			L = Integer.parseInt(st.nextToken());
			
			sc = new int[N];
			cal = new int[N];
					
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				sc[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0 ,0);
			
			System.out.println("#" + test_case + " " + max);
		}
		
	}
	
	static void dfs(int cnt, int x, int sum) {
		
		if( sum > L ) {
			return;
		}
		
    	if(cnt == N) {
    		if(x>max) {
    			max = x;
    		}
        	return;
    	}

		
		dfs(cnt + 1, x + sc[cnt], sum + cal[cnt] );
		dfs(cnt + 1, x, sum);
	}
	
}