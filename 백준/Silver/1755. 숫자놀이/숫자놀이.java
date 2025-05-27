import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
	static String mapping[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 숫자를 문자열로 변환한 후 저장할 리스트
		List<String> numbers = new ArrayList<>();
		// 문자열을 key로, 숫자를 value로 하는 맵 
		Map<String, Integer> map = new HashMap<>();
		
		// 한 자릿수, 두 자릿수에 대해 각각 문자열로 변환
		for(int i=M;i<=N;i++) {
			String mappingString = "";
			
			// 한 자릿수일 경우
			if(i <10) {
				mappingString = mapping[i];
			}
			// 두 자릿수일 경우
			else {
				mappingString = mapping[i/10] + " " + mapping[i%10];
			}
			
			map.put(mappingString, i);
			
			numbers.add(mappingString);
		}
		
		Collections.sort(numbers);
		
		StringBuilder sb  = new StringBuilder();
		for(int i=0;i<numbers.size();i++) {
			if(i> 1 && i%10 == 0) sb.append("\n");
			sb.append(map.get(numbers.get(i))+" ");
			
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
		
	}
}