
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N ;
    static int[] num;
    static int[] sign = new int[4]; // 부로 담을 배열
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1); // 첫번째 숫자 들어간다?

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int n, int index) {
        if (index == N) {
            MAX = Math.max(MAX, n);
            MIN = Math.min(MIN, n);
            return;
        }

        // 백트래킹???????????????????????
        for (int i = 0; i < 4; i++) {
        	
            if (sign[i] > 0) {
                sign[i]--;
                switch (i) {
                    case 0: dfs(n + num[index], index + 1);   break;
                    case 1:	dfs(n - num[index], index + 1);   break;
                    case 2:	dfs(n * num[index], index + 1);   break;
                    case 3: dfs(n / num[index], index + 1);   break;
                }
                sign[i]++;
            }
        }
    }
}