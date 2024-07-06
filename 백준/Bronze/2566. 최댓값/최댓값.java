import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        int[][] map = new int[10][10];
        int max = 0;
        int y = 0;
        int x = 0;
        for (int i = 1; i < 10; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( map[i][j] >= max) {
					max = map[i][j];
					y = i;
					x = j;
				}
				
			}
		}
        System.out.println(max);
        System.out.print(y + " " + x);
        
    }
}