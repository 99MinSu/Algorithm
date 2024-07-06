import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int ans = A * B;
        
        while(B != 0) {
        	int r = A % B;
        	
        	A = B;
        	B = r;
        }
        
        System.out.println(A);
        System.out.println(ans/A);
    }


}
 
