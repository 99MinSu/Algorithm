import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[] arr = new int[43];
    	
    	for (int i = 0; i < 10; i++) {
    		int n = Integer.parseInt(br.readLine());
			arr[n%42]++;
		}
    	int sum = 0;
    	for (int i = 0; i < 43; i++) {
			if(arr[i] != 0) {
				sum++;
			}
		}
        System.out.println(sum);
    }
}
 