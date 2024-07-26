import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] xarr = new int[1001];
		int[] yarr = new int[1001];		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xarr[x]++;
			yarr[y]++;			
		}
		
		for (int i = 0; i <= 1000; i++) {
			if(xarr[i] == 1) {
				System.out.print(i + " ");
			}
		}
        for (int i = 0; i <= 1000; i++) {
			if(yarr[i] == 1) {
				System.out.print(i);
			}
		}
    }
    
}