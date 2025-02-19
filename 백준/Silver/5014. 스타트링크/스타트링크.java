import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] arr = new int[F + 1];

        System.out.println(BFS(F, S, G, U, D, arr));

    }

    public static String BFS(int Floor, int start, int end, int up, int down, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        arr[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                return String.valueOf(arr[current] - 1);
            }
            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점
            if (current + up <= Floor) {
                if (arr[current + up] == 0) {
                    arr[current + up] = arr[current] + 1;
                    q.offer(current + up);
                }

            }
            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점
            if (current - down > 0) {
                if (arr[current - down] == 0) {
                    arr[current - down] = arr[current] + 1;
                    q.offer(current - down);
                }
            }

        }
        return "use the stairs";
    }
}
