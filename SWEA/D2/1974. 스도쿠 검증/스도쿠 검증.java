import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 

        for (int tc = 1; tc <= T; tc++) {
            int[][] board = new int[9][9];

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 1; 

            for (int i = 0; i < 9; i++) {
                boolean[] check = new boolean[10]; 
                for (int j = 0; j < 9; j++) {
                    int num = board[i][j];
                    if (check[num]) {
                        result = 0;
                        break;
                    }
                    check[num] = true;
                }
                if (result == 0) break;
            }

            if (result == 1) {
                for (int j = 0; j < 9; j++) {
                    boolean[] check = new boolean[10];
                    for (int i = 0; i < 9; i++) {
                        int num = board[i][j];
                        if (check[num]) {
                            result = 0;
                            break;
                        }
                        check[num] = true;
                    }
                    if (result == 0) break;
                }
            }
            
            if (result == 1) {
                for (int row = 0; row < 9; row += 3) {
                    for (int col = 0; col < 9; col += 3) {
                        boolean[] check = new boolean[10];
                        for (int i = row; i < row + 3; i++) {
                            for (int j = col; j < col + 3; j++) {
                                int num = board[i][j];
                                if (check[num]) {
                                    result = 0;
                                    break;
                                }
                                check[num] = true;
                            }
                        }
                        if (result == 0) break;
                    }
                    if (result == 0) break;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}