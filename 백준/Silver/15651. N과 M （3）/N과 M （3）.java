import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
		arr = new int[m];
		visit = new boolean[n+1];
		dfs(0);
		
		System.out.println(sb);
		
    }
    
    static void dfs(int dep) {
    	
    	if(dep == m) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
    	}
    	
		for (int i = 1; i <= n; i++) {
			arr[dep] = i;
			dfs(dep + 1);
		}
    }
}