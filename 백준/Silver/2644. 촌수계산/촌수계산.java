import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> adjList = new ArrayList<>();
    static int n, m, x, y, ans = -1;
    static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        
        dfs(a, b, 0);
        System.out.println(ans);
    }
    
    static void dfs(int start, int end, int cnt) {
        if (start == end) {
            ans = cnt;
            return;
        }
        
        visit[start] = true;
        
        for (int next : adjList.get(start)) {
            if (!visit[next]) {
                dfs(next, end, cnt + 1);
            }
        }
    }
}