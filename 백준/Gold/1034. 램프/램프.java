import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int ans = 0;
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
		
        map = new int[N][M];
		
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
		
        int K = Integer.parseInt(br.readLine()); // 스위치를 누를 수 횟수
        visited = new boolean[N]; // 방문 여부
        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
			
            visited[i] = true;
			
            // 행마다 0의 개수 구하기
            int OffRamp = 0; 
            for (int num : map[i]) {
                if (num == 0) {
                    OffRamp++;
                }
            }
			
            // 같은 모양의 행 개수 찾기
            int SameRowCnt = find(i);
			
            // K와 0의 개수의 홀짝이 같고, K가 같거나 클 경우
            if (K % 2 == OffRamp % 2 && K >= OffRamp) {
                ans = Math.max(ans, SameRowCnt);
            }
        }
		
        System.out.println(ans);
    }
	
    public static int find(int row) {
        int cnt = 0;
		
        // 같은 행 비교
        for (int i=0; i<N; i++) {
            if (Arrays.equals(map[i], map[row])) {
                visited[i] = true;
                cnt++;
            }
        }
		
        return cnt;
    }
}