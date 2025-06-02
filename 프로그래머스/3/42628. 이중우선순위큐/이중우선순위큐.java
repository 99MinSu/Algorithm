import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] arguments) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : arguments) {
            String[] parts = operation.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (cmd.equals("I")) {
                pq.offer(num);
                reverse_pq.offer(num);
            } else if (cmd.equals("D")) {
                if (pq.isEmpty()) continue;

                if (num == 1) {
                    // 최대값 삭제
                    int max = reverse_pq.poll();
                    pq.remove(max);
                } else {
                    // 최소값 삭제
                    int min = pq.poll();
                    reverse_pq.remove(min);
                }
            }
        }

        if (!pq.isEmpty()) {
            answer[0] = reverse_pq.peek();
            answer[1] = pq.peek();
        }

        return answer;
    }
}