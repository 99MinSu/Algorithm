import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, A, sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        
        int index = N-1;
        
        while(true) {
        	if(K == 0) break;
        	
        	if(K >= arr[index]) {
        		K -= arr[index];
        		sum++;
        	}else {
        		index--;
        	}
        }

		System.out.println(sum);
	}

}