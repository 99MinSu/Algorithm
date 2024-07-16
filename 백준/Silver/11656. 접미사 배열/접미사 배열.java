import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        String[] s = new String[S.length()];
        
        for (int i = 0; i < S.length(); i++) {
			s[i] = S.substring(i, S.length());
		}
        
        Arrays.sort(s);
        
        for (String string : s) {
			System.out.println(string);
		}
    }

}