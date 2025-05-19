
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = Integer.parseInt(br.readLine());
			
			long[] arr = new long[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long cur = arr[N-1];
			
			long max = 0;
			for (int i = N - 2; i >= 0; i--) {
				
				if( cur < arr[i] ) {
					cur = arr[i];
				}else {
					max += cur - arr[i];
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}