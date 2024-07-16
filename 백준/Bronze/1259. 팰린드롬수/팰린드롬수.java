import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String S = br.readLine();

            String ans = "yes";
            for (int i = 0; i < S.length()/2; i++) {
				if(S.charAt(i) != S.charAt(S.length()-1 - i)) {
					ans = "no";
				}
			}            
            if(S.equals("0")) break;
            else {
                System.out.println(ans);
            }
        }
    }

}