import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	String[][] people = new String[N][2];
    	
    	for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				people[i][j] = st.nextToken();
			}
		}
    	Arrays.sort(people, new Comparator<String[]>() {
    		public int compare(String[] s1, String[] s2){
    			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
    		}
    	});
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(people[i][j] + " ");
			}
			System.out.println();
		}
    }
}

