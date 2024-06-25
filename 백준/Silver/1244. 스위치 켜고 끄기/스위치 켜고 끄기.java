import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        n = Integer.parseInt(br.readLine());
             
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}       
        count = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < count; i++) {
        	st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (gender == 1) { // 남자
                for (int k = number; k <= n; k += number) {
                    if (arr[k] == 1) {
                        arr[k] = 0;
                    } else {
                        arr[k] = 1;
                    }
                }
            } else { // 여자
                int left = number - 1;
                int right = number + 1;
                while (left > 0 && right <= n) {
                    if (arr[left] != arr[right]) {
                        break;
                    }
                    left--;
                    right++;
                }
                for (int k = left + 1; k < right; k++) {
                    if (arr[k] == 1) {
                        arr[k] = 0;
                    } else {
                        arr[k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }      
}