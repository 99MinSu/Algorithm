import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
        // 맵
		HashMap<String, String> m = new HashMap<String, String>();
        
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			if (m.containsKey(name)) m.remove(name); //최초 입력이 아니면 나간거
			else m.put(name, log); //최초 입력이면 들어온거
		}
		ArrayList<String> list = new ArrayList<String>(m.keySet()); //Hash맵의 Key들을 ArrayList로 변경
		Collections.sort(list, Collections.reverseOrder()); //내림차순으로 정렬
		for(int i = 0; i < list.size(); ++i) System.out.println(list.get(i));
	}
}