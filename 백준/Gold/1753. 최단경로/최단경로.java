import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그래프 자료구조 (인접 행렬, 인접 리스트)
// 비용관리 배열(시작점으로부터 각 정점까지의 최소비용(최단거리))
// 고려하는(Queue 에 담긴) 정점 중 시작점에서부터 최소비용의 정점 찾는 PriorityQueue
// 최소비용으로 고려했던(방문했던) 정점 관리 visit
// PriorityQueue 에 담을 Vertex(Node) 클래스 (정점 번호, 시작점으로부터의 비용)
public class Main {
    
    static class Node {
        int v; // 정점 번호
        int c; // 비용
        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    static int V, E, start;
    static List<List<Node>> adjList = new ArrayList<>();
    static int[] cost; // 시작점으로부터 각 정점까지의 최소비용
    static boolean[] visit;
    static final int INF = Integer.MAX_VALUE; // cost 배열 초기화
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        cost = new int[V + 1];
        visit = new boolean[V + 1];

        // 입력 E 개 -> 인접 리스트 구성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(v1).add(new Node(v2, c));
        }
        // 비용 테이블 충분히 큰 값으로 초기화
        Arrays.fill(cost, INF);

        // 다익스트라
        cost[start] = 0;
        pqueue.offer(new Node(start, 0)); // 시작 정점을 넣고 다익스트라 진행

        while (!pqueue.isEmpty()) { // 전체를 모두 끝내면 모든 정점에 대한 최단경로(최소비용)이 완성
            Node node = pqueue.poll();
            if (visit[node.v]) continue; // 이미 방문한 정점 skip
            visit[node.v] = true;

            for (Node n : adjList.get(node.v)) {
                if (!visit[n.v] && cost[n.v] > cost[node.v] + n.c) {
                    cost[n.v] = cost[node.v] + n.c; // 최소 비용 갱신 (n.v)
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (cost[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(cost[i]);
            }
        }
    }
}

