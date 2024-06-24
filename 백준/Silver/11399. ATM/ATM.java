import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, sum;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(arr);
        int add = 0;
        
        for (int i = 0; i < N; i++) {
            add += arr[i];
            sum += add;
        }
        
        System.out.println(sum);

	}

}