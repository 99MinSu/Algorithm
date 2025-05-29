import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
	public static int N, M;
	public static int[] arr;
	public static int[] prefixSum;
	public static long answer = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()); 	
 
    	N = Integer.parseInt(st.nextToken());
    		
    	int sumValue = 0;
    	prefixSum = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		sumValue += Integer.parseInt(st.nextToken());
    		prefixSum[i+1] = sumValue;
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		System.out.println(prefixSum[b] - prefixSum[a-1]);
    	}
    }   
}