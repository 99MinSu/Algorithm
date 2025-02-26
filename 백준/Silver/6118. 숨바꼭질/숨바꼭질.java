import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기 (양방향 그래프)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        // BFS 실행하여 거리 계산
        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        bfs(1);

        // 결과 찾기
        int maxDist = 0;
        int farthestBarn = 0;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] > maxDist) {
                maxDist = distance[i];
                farthestBarn = i;
                count = 1;
            } else if (distance[i] == maxDist) {
                count++;
                farthestBarn = Math.min(farthestBarn, i); // 가장 작은 헛간 번호 선택
            }
        }

        System.out.println(farthestBarn + " " + maxDist + " " + count);
    }

    // BFS 탐색
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (distance[next] == -1) { // 방문하지 않은 경우
                    distance[next] = distance[node] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
