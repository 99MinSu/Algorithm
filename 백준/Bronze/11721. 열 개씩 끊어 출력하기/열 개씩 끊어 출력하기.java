import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(); 
        
        for (int i = 0; i < S.length(); i++) {
			System.out.print(S.charAt(i));
			
			if((i+1) % 10 == 0) {
				System.out.println();
			}
		}
    }

}