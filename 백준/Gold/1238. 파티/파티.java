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
	
	static class Node{
		int v; // 정점 번호
		// 인접 리스트에 Node 를 사용할 경우 : 인접 리스트 정점 ~> V 정점까지의 비용(거리)
		// PriorityQueue 에 Node 를 사용할 경우 : 시작정점으로부터의 최소 비용(거리)
		int c; 
		Node(int v, int c){
			this.v = v;
			this.c = c;
		}		
	}
	static int N,M,X, start, ans;
	static List<List<Node>> adjList = new ArrayList<>();
	static List<List<Node>> radjList = new ArrayList<>();
	static int[] cost;
	static int[] rcost; 
	static int[] tempCost; 
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE; // cost 배열 초기화
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
			radjList.add(new ArrayList<>());
		}		
		
		// 입력 E 개 -> 인접 리스트 구성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList.get(v1).add(new Node(v2,c));
			radjList.get(v2).add(new Node(v1,c));
		}
		// 비용 테으블 충분히 큰 값으로 초기화

        cost = dijkstra(X, adjList); 
        rcost = dijkstra(X, radjList); 
        
        for (int i = 1; i < N+1 ; i++) {
            ans = Math.max(ans, cost[i]+ rcost[i]);
        }
        
        System.out.println(ans);
	}
	
	static int[] dijkstra(int start, List<List<Node>> adjList2){
		
		tempCost = new int[N+1];
        visit = new boolean[N+1];

        Arrays.fill(tempCost, INF); 
        Arrays.fill(visit, false);
              
        tempCost[start] = 0; //시작점이기 때문에 거리 0으로 셋팅
        pqueue.add(new Node(start, 0));
        
		while(! pqueue.isEmpty()) { 
			
			Node node = pqueue.poll();
			if( visit[node.v]) continue;
			visit[node.v] = true;
			
			for (Node n : adjList2.get(node.v)) {
				if( visit[n.v] ) continue;
				if( tempCost[n.v] > tempCost[node.v] + n.c) {
					tempCost[n.v] = tempCost[node.v] + n.c; // 최소 비용 갱신 (n.v)
					pqueue.offer(new Node(n.v, tempCost[n.v]));
				}
			}
		}
		return tempCost;
    }

}