import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int N, white, blue, red;
	static int[][] map; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(0,0, N);
		System.out.println(red);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void paper(int y, int x, int size) {

		if(check(y,x,size)) {
			if( map[y][x] == 0	) {
				white++;
			}else if( map[y][x] == 1) {
				blue++;
			}else {
				red++;
			}
			return;
		}

		
		int nsize = size/3;
		
		paper(y , x , nsize);
		paper(y , x + nsize, nsize);
		paper(y + nsize , x , nsize);
		paper(y + nsize , x + nsize , nsize);
		paper(y , x + nsize * 2, nsize);
		paper(y + nsize , x + nsize * 2 , nsize);
		paper(y + nsize * 2 , x , nsize);
		paper(y + nsize * 2 , x + nsize , nsize);
		paper(y + nsize * 2, x + nsize * 2 , nsize);
	}
	
	static boolean check(int y, int x, int size) {
		 
		int value = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x+ size; j++) {
				if(map[i][j] != value) {
					return false;			
				}				
			}
		}
		return true;
	}
}