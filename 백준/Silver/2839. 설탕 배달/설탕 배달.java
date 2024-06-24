import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        
		while(N>0) {
			if(N % 5 == 0) {
				count += N/5; 
				break;
			}else {
				N -= 3;
				count++;
			}
			if(N < 0) {
				count = -1;
			}
			
		}
		
		System.out.println(count);
	}

}