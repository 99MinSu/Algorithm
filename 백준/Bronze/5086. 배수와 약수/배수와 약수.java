import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            if (n1 == 0 && n2 == 0) break;
            
            if( n1 % n2 == 0) {
            	sb.append("multiple");
            }else if( n2 % n1 == 0) {
            	sb.append("factor");
            }else {
            	sb.append("neither");
            }
            System.out.println(sb);
        }
    }
}