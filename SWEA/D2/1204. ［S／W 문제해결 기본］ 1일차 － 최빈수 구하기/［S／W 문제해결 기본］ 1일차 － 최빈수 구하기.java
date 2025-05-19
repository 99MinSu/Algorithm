
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
			
			int[] score = new int[101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= 1000; i++) {
				
				int s = Integer.parseInt(st.nextToken());
				
				score[s]++;
				
			}
			
			int max = 0;
			int count = 0;
			
			for(int i = 1; i <= 100; i++) {
								
				if ( max <= score[i] ) {
					max = score[i];
					count = i;
				}
				
			}
			
			System.out.println("#" + N + " " + count);
		}
	}
}