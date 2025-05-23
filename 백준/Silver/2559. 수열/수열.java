import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 0; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        int[] temperature = new int[N]; // 온도 저장
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken()); // 온도 입력 받아 저장
        }

        for (int i = 0; i < K; i++) {
            max = max + temperature[i]; // 0번째부터 K개만큼 온도 구간 우선 더하기. 우선 max로 놓기
        }
        
        int temp = max; // 구간 온도의 합. temp로 아래 계산을 할 것
        
        for (int i = K; i < N; i++) {
            // 1번쨰부터 K개만큼의 온도 구간: 0번째부터 K개만큼 온도 구간 - 0번째 + K번째
            temp = temp - temperature[i - K] + temperature[i];
            max = Math.max(max, temp); // 더 큰 수를 저장
        }

        System.out.println(max); 
    }
}