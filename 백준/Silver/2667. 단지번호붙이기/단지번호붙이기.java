import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m, result, count;
    static char[][] graph;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };
    
    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    static void dfs(int y, int x) {
        
        // 해당 노드 방문 처리
    	graph[y][x] = '0'; 
        count++;
    	
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if( ny < 0 || nx < 0 || ny >= n || nx >= n || graph[ny][nx] != '1') continue;
            dfs(ny, nx);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = Integer.parseInt(br.readLine());

        graph = new char[n][];
        
        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        // 모든 노드(위치)에 대하여 음료수 채우기

        ArrayList<Integer> arr = new ArrayList<>();
        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	count = 0;
                if( graph[i][j] == '1') {
                    dfs(i, j);
                    arr.add(count);
                    result++;
                }
            }
        }
        Collections.sort(arr);
        System.out.println(result);
        for(int i : arr){
            System.out.println(i);
        }
    }
}

// BFS로 풀기
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Queue;

// public class Main {
//     static int n, result, count;
//     static char[][] graph;
//     static int[] dy = { -1, 1, 0, 0 };
//     static int[] dx = {  0, 0,-1, 1 };
    
//     static class Node{
//     	int y, x;
//     	Node(int y, int x){
//     		this.y = y;
//     		this.x = x;
//     	}
//     }
    
//     static Queue<Node> queue = new ArrayDeque<>();
//     static void bfs(int y, int x) {
        
//         // 해당 노드 방문 처리
//         graph[y][x] = '0';
//         count++;
//         queue.offer(new Node(y, x));
        
//         while( !queue.isEmpty()) {
//         	Node node = queue.poll();
//             for (int d = 0; d < 4; d++) {
//                 int ny = node.y + dy[d];
//                 int nx = node.x + dx[d];
                
//                 if( ny < 0 || nx < 0 || ny >= n || nx >= n || graph[ny][nx] != '1') continue;
//                 queue.offer(new Node(ny, nx));
//                 graph[ny][nx] = '0';    
//                 count++;
//             }
//         }
       
//     }
    
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         // N, M을 공백을 기준으로 구분하여 입력 받기
//         n = Integer.parseInt(br.readLine());

//         graph = new char[n][];
        
//         // 2차원 리스트의 맵 정보 입력 받기
//         for (int i = 0; i < n; i++) {
//             graph[i] = br.readLine().toCharArray();
//         }
//         // 모든 노드(위치)에 대하여 음료수 채우기

//         ArrayList<Integer> arr = new ArrayList<>();
//         result = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//             	count = 0;
//                 if( graph[i][j] == '1') {
//                     bfs(i, j);
//                     arr.add(count);
//                     result++;
//                 }
//             }
//         }
//         Collections.sort(arr);
//         System.out.println(result);
//         for(int i : arr){
//             System.out.println(i);
//         }
//     }
// }
