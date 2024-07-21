import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] S = new String[N];
		
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}
		
		String[] S1 = new String[M];
		
		for (int i = 0; i < M; i++) {
			S1[i] = br.readLine();
		}
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(S[i].equals(S1[j])) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}