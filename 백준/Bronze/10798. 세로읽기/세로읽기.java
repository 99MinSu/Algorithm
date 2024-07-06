import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        String[] s = new String[5];
        int max = 0;
        
        for (int i = 0; i < 5; i++) {
			s[i] = br.readLine();
			max = Math.max(max, s[i].length());
		}
        
        for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {	
				if(s[j].length() <= i) {
					continue;
				}
				System.out.print(s[j].charAt(i));
			}
		}
        
    }
}