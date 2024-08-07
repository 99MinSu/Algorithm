import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] distance = new long[N-1];
        long[] cost = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N - 1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N ; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
        
        
        long min = cost[0];
        long ans = 0;
        for (int i = 0; i < distance.length; i++) {
			if( cost[i] < min) {
				min = cost[i];
			}
			
			ans += min * distance[i];
		}
        
        System.out.println(ans);
        
    }

}