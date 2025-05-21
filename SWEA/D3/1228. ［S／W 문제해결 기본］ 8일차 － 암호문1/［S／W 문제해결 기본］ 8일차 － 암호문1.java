import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine()); 

            LinkedList<String> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); // 명령어 개수
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                String command = st.nextToken(); // 'I'
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for (int j = 0; j < y; j++) {
                    list.add(x + j, st.nextToken()); // 해당 위치에 삽입
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

        br.close();
    }
}