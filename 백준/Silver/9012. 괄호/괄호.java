import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, count;
	static String ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			count = 0;
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					count++;
				}else if(s.charAt(j) == ')') {
					count--;
				}
				if(count < 0) {
					ans = "NO";
					break;
				}
			}
			if(count == 0) {
				ans = "YES";
			}else
				ans = "NO";
			System.out.println(ans);
		}

	}
 
}