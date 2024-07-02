import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST
// 간선 중심 - 간선 리스트
public class Main {
	
	static int V, E, result; // MST 총 비용
	static int[] parent;
	static Edge[] edges; // 간선 리스트
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(v1,v2,c);
		}
		
		// 입력 처리
		// 쿠르스칼 알고리즘
		Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
		// 집합 배열 처리
		makeSet();
		
		int cnt = 0; // V - 1 개 만들면 된다. (cycle 이 없는)
		for (Edge edge : edges) {
			//cycle 체크
			if(union(edge.v1,edge.v2)) {
				result += edge.c;
				cnt++;
				if(cnt == V )break;
			}
		}
		System.out.println(result);
	}
	
	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i; // 자기 자신이라 서로소
		}
	}
	
	static int findSet(int x) { // 정점의 부모를 찾는 기능
		if (x == parent[x]) return x;
		return parent[x] = findSet(parent[x]);
	}

//	static void union(int x, int y) { // 두 부모의 수 중 작은 수를 부모로
//		int px = findSet(x);
//		int py = findSet(y);
//		if(px < py) parent[py] = px;
//		else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
//	}
	
	static boolean union(int x, int y) { // 쿠르스칼 사용 버전
		int px = findSet(x);
		int py = findSet(y);
		
		if(py == px) return false;
		
		if(px < py) parent[py] = px;
		else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
		
		return true;
	}
	
	static class Edge{
		int v1, v2, c;
		
		Edge(int v1, int v2, int c){
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}
}