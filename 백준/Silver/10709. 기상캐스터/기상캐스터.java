import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int ROWS = Integer.parseInt(st.nextToken());
        final int COLS = Integer.parseInt(st.nextToken());
        int answer[][] = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                answer[i][j] = -1;
            }
        }
        for (int i = 0; i < ROWS; i++) {
            char temp[] = br.readLine().toCharArray();
            for (int j = 0; j < COLS; j++) {
                if (temp[j] == 'c') {
                    int cloudMinute = 0;
                    for (int jj = j; jj < COLS; jj++) {
                        answer[i][jj] = cloudMinute;
                        cloudMinute++;
                    }
                }
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                sb.append(answer[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }


        sb.append("\n");
        System.out.println(sb);
    }


}