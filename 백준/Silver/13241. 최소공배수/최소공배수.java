import java.io.*;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long longA = Long.parseLong(st.nextToken());
		long longB = Long.parseLong(st.nextToken());
		
		long a = longA;
		long b = longB;
		long temp;

        // 유클리드 호제법 b != 0 아니면 계속 돌면서 해주면 a가 최대공약수
		while( b != 0 ){

			temp = a % b;
			a = b;
			b = temp;

		}
		System.out.println(longA * longB / a);
	}
}