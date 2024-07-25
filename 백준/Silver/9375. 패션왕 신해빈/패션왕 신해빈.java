import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			HashMap<String, Integer> h = new HashMap(); 
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String types = st.nextToken();
				if (h.containsKey(types)) {
					h.put(types, h.get(types) + 1);
				} else {
					h.put(types, 1);
				}
			}
			int result = 1;
			for (int val : h.values()) { //안입는 경우 포함
				result *= (val + 1);
			}

			System.out.println(result - 1);
		}

	}

}