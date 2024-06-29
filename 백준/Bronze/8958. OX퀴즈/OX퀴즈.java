import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n,sum, cnt;
	static String[] arr;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	arr = new String[n];
    	
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

    	
    	for (int i = 0; i < n; i++) { 		
    		sum = 0;
    		cnt = 0;
    		for (int j = 0; j < arr[i].length(); j++) {
    			if(arr[i].charAt(j) == 'O') {
    				cnt += 1;
    			}else
    				cnt = 0;
    			sum += cnt;
			}
			System.out.println(sum);
		}   	
    }
}