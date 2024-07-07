import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if ( n == -1) break;
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(" ").append("=").append(" ");           
            int sum = 0;
        	for (int i = 1; i < n; i++) {
				if( n % i == 0) {
					sum += i;
					sb.append(i).append(" ").append("+").append(" ");
				}				
			}
			if(sum == n) {
				sb.setLength(sb.length()-2);
				System.out.println(sb);
			}else
				System.out.println(n + " "+ "is NOT perfect.");
        }
    }
}