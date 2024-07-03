import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] s1 = br.readLine().split("-");
    	
    	int sum = 0;
    	for (int i = 0; i < s1.length; i++) {
        	int temp= 0;
			String[] s2 = s1[i].split("\\+");
			for (int j = 0; j < s2.length; j++) {
				temp += Integer.parseInt(s2[j]);
			}
			if( i == 0) {
				sum += temp;
			}else {
				sum -= temp;	
			}
		}
    	
    	
    	System.out.println(sum);
    }
}

