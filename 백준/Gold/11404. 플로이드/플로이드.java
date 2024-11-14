import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // distance 배열: 도시 간 최단 거리 저장
    static int[][] distance;
    // 도시 수와 버스 수
    static int city, bus;
    // MAX 값은 무한대를 나타내기 위해 사용 (도달할 수 없는 경우 설정)
    static final int MAX = 10000001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());

        // distance 배열 초기화 (1부터 city까지 사용할 것이므로 city+1 크기로 생성)
        distance = new int[city + 1][city + 1];

        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if(i == j){
                    // 같은 도시로 가는 경우 거리는 0
                    distance[i][j] = 0;
                } else {
                    // 다른 도시로 가는 경우, 초기값을 MAX로 설정 (초기 무한대 값)
                    distance[i][j] = MAX;
                }
            }
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용
            // 동일 노선의 경우, 더 작은 비용을 유지
            if(distance[a][b] > c)
                distance[a][b] = c;
        }

        floydWarshall();

        // StringBuilder 사용하여 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if(distance[i][j] == MAX){
                    // 도달할 수 없는 경우 0 출력
                    sb.append(0).append(" ");
                } else {
                    // 도달할 수 있는 경우 최단 거리 출력
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n"); // 행 구분을 위해 줄바꿈
        }
        System.out.print(sb); // 한 번에 출력
    }

    // Floyd-Warshall 알고리즘을 이용해 모든 도시 쌍 간 최단 거리 계산
    public static void floydWarshall(){
        for (int k = 1; k <= city; k++) { // 경유 도시
            for (int i = 1; i <= city; i++) { // 출발 도시
                for (int j = 1; j <= city; j++) { // 도착 도시
                    // 현재 최단 거리와 경유지를 거친 거리 비교하여 더 작은 값으로 갱신
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}
