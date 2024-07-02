import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result, max;
    static List<List<Vertex>> adjList; // 인접 리스트
    static boolean[] visit; // 방문 체크
    
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<Vertex>( (e1, e2) -> e1.c - e2.c );
    
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        visit = new boolean[N+1];
        for (int i = 0; i <= N; i++) { 
            adjList.add(new ArrayList<Vertex>());
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList.get(v1).add(new Vertex(v2,c));
			adjList.get(v2).add(new Vertex(v1,c));
		}
        
        pqueue.clear();
        
        prim();
        System.out.println(result - max);
	}
	
    static void prim() {

        int cnt = 1;
        visit[1] = true;
        
        pqueue.addAll(adjList.get(1)); 
        
        while(! pqueue.isEmpty() ) {
            
            Vertex vertex = pqueue.poll();
            if( visit[vertex.v] ) continue; 
            
            visit[vertex.v] = true;
            result += vertex.c;
            cnt++;
            
            if(vertex.c> max) {
            	max = vertex.c;
            }
            
            if( cnt == N  ) break; 
            for (Vertex v : adjList.get(vertex.v)) {
                if( !visit[v.v] ) pqueue.add(v);
            }
        }
    }
	
	static class Vertex{
		int v, c;
		public Vertex(int v, int c){
			this.v =v;
			this.c =c;
		}
	}

}