import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        visited = new boolean[N + 1]; //방문체크 배열
        visited[1] = true;

        for (int i = 0; i < M; i++) { // 양방향 인접리스트 구현
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        dfs(1, 0);

        int answer = 0;
        for (int i = 2; i < visited.length; i++) {// i = 1 : 상근이라 카운트X
            if(visited[i]) answer++;
        }
        System.out.println(answer);
    }
    private static void dfs(int point, int cnt){
        if(cnt == 2) { // 친구의 친구의 친구까지
            return;
        }
        for(int i : graph.get(point)) {
            visited[i] = true;
            dfs(i, cnt+1);
        }
    }
}