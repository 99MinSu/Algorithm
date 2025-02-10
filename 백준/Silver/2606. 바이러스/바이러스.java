import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,V,count;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit; // 중복 방문 방지
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());


        for (int i = 0; i < N + 1; i++) { // 0 dummy
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }


        visit = new boolean[N + 1];

        dfs(1);
        System.out.println(count -1); // 1번 제외 감염된 컴퓨터 수
    }


    static void dfs(int n) { // n : 시작 정점
        visit[n] = true;

        List<Integer> list = adjList.get(n);
        count++;
        for (Integer i : list) {
            if( visit[i] ) continue;
            dfs(i);
        }
    }
}