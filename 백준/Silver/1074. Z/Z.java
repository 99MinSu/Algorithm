import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,r,c, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		N = (int) Math.pow(2,N); 
		
		int y = 0;
		int x = 0;
		
		// (r,c) 위치까지 찾아질 동안 계속 분할 처리
		while(true) {
			if(N == 1)break;
			
			N /= 2;
			
			if( r < y + N && c < x + N) {
				; // 분할 영역
			}
			else if( r < y + N && c >= x + N) {
				ans += N * N;
				x += N;
			}else if( r >= y + N && c < x + N) {
				ans += N * N * 2;
				y += N;
			}else {
				ans += N * N * 3;
				y += N;
				x += N;
			}
		}
		System.out.println(ans);
	}

}

// 재귀함수로 바꿔보기
public class Z2 {

	static int N,r,c, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		N = (int) Math.pow(2,N); 
		
		int y = 0;
		int x = 0;
		 
		z(0,0);
		
		System.out.println(ans);
	}
	
	static void z(int y, int x) {
		if(N == 1)return;
		N /= 2;
		
		if( r < y + N && c < x + N) {
			z(y,x);
		}
		else if( r < y + N && c >= x + N) {
			ans += N * N;
			z(y, x + N);
		}else if( r >= y + N && c < x + N) {
			ans += N * N * 2;
			z(y+ N, x );
		}else {
			ans += N * N * 3;
			z(y+ N, x + N );
		}
	}

}
