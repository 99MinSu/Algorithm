import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer,String> map1 = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String pocketmon = br.readLine();
			map1.put(i, pocketmon);
			map2.put(pocketmon, i);
		}
		
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if(s.charAt(0) - '0' > 0 && s.charAt(0)- '0' < 10) {
				int key = Integer.parseInt(s);
				sb.append(map1.get(key));
			}
			else {				
				sb.append(map2.get(s));
			}		
			sb.append("\n");						
		}
		System.out.println(sb);
	}

}