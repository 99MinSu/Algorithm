import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	String[] s = new String[N];
    	
    	for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}
    	
		Arrays.sort(s, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 단어 길이가 같을 경우 
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} 
				// 그 외의 경우 
				else {
					return s1.length() - s2.length();
				}
			}
		});

	     	// 람다식으로 바꿔보기
//		Arrays.sort(s, (s1, s2) -> {
//		    // 단어 길이가 같을 경우
//		    if (s1.length() == s2.length()) {
//		        return s1.compareTo(s2);
//		    } else {
//		        return s1.length() - s2.length();
//		    }
//		});
		
		System.out.println(s[0]);
		
		for (int i = 1; i < N ; i++) {
			// 중복되지 않는 단어만 출력
			if (!s[i].equals(s[i - 1])) {
				System.out.println(s[i]);
			}
		}
    }
}
