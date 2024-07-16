import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] distance = new int[N-1];
        int[] cost = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N ; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
        
        
        int min = cost[0];
        int ans = 0;
        for (int i = 0; i < distance.length; i++) {
			if( cost[i] < min) {
				min = cost[i];
			}
			
			ans += min * distance[i];
		}
        
        System.out.println(ans);
        
    }

}