import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int triangle[] = new int[45];
		
		for(int i = 1; i<45; i++) {
			
			triangle[i] = i*(i+1)/2;
		}
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			int result = triangleSum(num, triangle);
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int triangleSum(int n, int triangle[]) {
		for(int i = 1; i<45; i++) {
			for(int j = 1; j<45; j++) {
				for(int k = 1; k<45; k++) {
					int sum = triangle[i] + triangle[j] + triangle[k];
					if(sum == n) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

}