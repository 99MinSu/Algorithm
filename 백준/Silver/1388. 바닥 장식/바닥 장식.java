import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] isVisited;
    static char arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        isVisited = new boolean[n][m];

        //문자 입력받기 
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] =  str.charAt(j);
            }
        }

        int cnt=0;
        //전체 배열 돌면서 dfs로 탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                //방문하지 않은 노드라면 dfs수행 
                if(!isVisited[i][j]) {
                    dfs(i,j);
                    cnt++;

                }

            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        // '-'인 경우, 오른쪽으로만 이동하면서 탐색
        if (arr[x][y] == '-') {
            //오른쪽이 배열의 경계를 넘지 않고 && 그다음도 '-'이고 && 그다음도 방문하지 않았으면
            if (y + 1 < m && arr[x][y + 1] == '-' && !isVisited[x][y + 1]) {
                dfs(x, y + 1); //재귀호출하여 오른쪽으로 다시 이동하여 탐색
            }
        }

        // '|'인 경우, 아래쪽으로만 이동하면서 탐색
        if (arr[x][y] == '|') {
            if (x + 1 < n && arr[x + 1][y] == '|' && !isVisited[x + 1][y]) {
                dfs(x + 1, y);
            }
        }

    }
}