import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        br.close();

        System.out.println(bfs(A));
    }

    public static int bfs(long n) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long now = queue.poll();

                if (now == B) {
                    return cnt + 1;
                }

                if (now * 2 <= B) queue.offer(now * 2);
                if (now * 10 + 1 <= B) queue.offer(now * 10 + 1);
            }
            cnt++;
        }

        return -1;
    }
}
