import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int t, count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if(cheese[i][j]==1) count++; //치즈 조각 개수
            }
        }



        bfs();
    }

    public static void bfs(){
        //(0,0)부터 치즈 녹이기
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited = new boolean[n][m];
        visited[0][0] = true;
        
        int melted = 0; //녹은 가장자리 치즈
        t++;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(cheese[nx][ny]==0){
                    q.add(new Point(nx, ny)); //계속 탐색 진행
                }
                else{
                    //치즈가 녹음
                    cheese[nx][ny] = 0;
                    melted++;
                }
            }
        }

        count -= melted;

        //치즈가 다 녹았다면
        if(count==0){
            System.out.println(t);
            System.out.println(melted);
            return;
        }
        else{
            bfs();
        }
    }

    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}