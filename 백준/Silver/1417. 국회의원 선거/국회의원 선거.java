import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 우선순위 큐

        for (int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // 다솜이가 1등이 아닐 동안
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int top = pq.poll();
            top--;         // 매수: 상대 후보의 표 -1
            dasom++;       // 다솜이 표 +1
            count++;       // 매수 횟수 +1
            pq.offer(top); // 다시 큐에 넣기
        }

        System.out.println(count);
    }
}
