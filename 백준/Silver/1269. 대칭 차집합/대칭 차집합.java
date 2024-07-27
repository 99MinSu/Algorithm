import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> ha1 = new HashMap<>();
		HashMap<Integer, Integer> ha2 = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			int N = Integer.parseInt(st.nextToken());
			ha1.put(N, 1);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(!ha1.containsKey(n)) {
				ha2.put(n, 1);
			}else
				ha1.remove(n);
		}
		System.out.println(ha1.size()+ha2.size());
	}
}