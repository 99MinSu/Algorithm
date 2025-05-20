import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc < 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] n = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i <100; i++) {
				n[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			Arrays.sort(n);

			for(int i =0; i < N; i++) {
				n[0] += 1;
				n[99] -= 1;
				Arrays.sort(n);
			}
			
			ans = n[99] - n[0];
			
			System.out.println("#"+(tc+1)+" "+ans);

		}
	}
}