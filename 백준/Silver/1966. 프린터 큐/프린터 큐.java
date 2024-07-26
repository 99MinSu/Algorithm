import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        for (int i=0; i<T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken());
			
            Queue<int[]> q = new LinkedList<int[]>();
			
            st = new StringTokenizer(br.readLine());
			
            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
				
                q.add(new int[] {j, num});
            }
			
            int cnt = 0;
            while (true) {
                int[] cur = q.poll();
                boolean chk = true;				
                for (int[] curQ : q) {
                    if (curQ[1] > cur[1]) {
                        chk = false;
                        break;
                    }
                }
                
                if (chk) {
                    cnt++;
                    if (cur[0] == M) break;
                } else {
                    q.add(cur);
                }
            }
			
            System.out.println(cnt);
        }
    }
}