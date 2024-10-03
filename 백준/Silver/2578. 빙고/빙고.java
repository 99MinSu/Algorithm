import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int count, num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                num++;
                bingo(Integer.parseInt(st.nextToken()));

                // 가로, 세로, 대각선 2개??
                col();
                row();
                xy();
                yx();

                if(count >= 3) { // 빙고 3개이면 우승
                    System.out.println(num);
                    return;
                }
                count = 0;
            }
        }
    }

    // 부른 숫자와 일치하는 빙고판 0으로 바꾸기
    static void bingo(int n) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == n) {
                    map[i][j] = 0;
                }
            }
        }
    }

    // 가로 췤
    static void row() {
        for(int i = 0; i < 5; i++) {
            int zeroCnt = 0;
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == 0) {
                    zeroCnt++;
                }
            }
            if(zeroCnt == 5) {
                count++;
            }
        }
    }

    // 세로 췤
    static void col() {
        for(int i = 0; i < 5; i++) {
            int zeroCnt = 0;
            for(int j = 0; j < 5; j++) {
                if(map[j][i] == 0) {
                    zeroCnt++;
                }
            }
            if(zeroCnt == 5) {
                count++;
            }
        }
    }

    // 대각선1 췤
    static void xy() {
        int zeroCnt = 0;

        for(int i = 0; i < 5; i++) {
            if(map[i][i] == 0) {
                zeroCnt++;
            }
            if(zeroCnt == 5) {
                count++;
            }
        }
    }

    // 대각선2 췤
    static void yx() {
        int zeroCnt = 0;

        for(int i = 0; i < 5; i++) {
            if(map[i][4 - i] == 0) {
                zeroCnt++;
            }
            if(zeroCnt == 5) {
                count++;
            }
        }
    }
}