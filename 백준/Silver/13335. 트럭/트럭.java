import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int bridgeWeight = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken())); // 트럭의 무게를 큐에 담음
        }

        for (int i = 0; i < w; i++) {
            bridge.add(0); // 현재 다리에 올라와있는 트럭의 무게 다리의 길이만큼 0으로 초기화
        }

        while (!bridge.isEmpty()) { // 현재 다리에 올라와 있는 트럭이 존재하지 않을 때 까지
            time++; // 시간 1 증가
            bridgeWeight-=bridge.poll(); // 다리에 올라와있는 트럭이 한대 씩 다리에서 내려옴
            if (!truck.isEmpty()) { // 큐에 담긴 트럭이 존재하지 않을 때 까지
                if (truck.peek() + bridgeWeight <= L) { // 트럭 큐에 담긴 맨앞의 값과 현재 다리위에 올라와있는 트럭의 무게의 합이 L 보다 낮을때
                    bridgeWeight += truck.peek();
                    bridge.add(truck.poll()); // 다리에 한 대 씩 올라감
                } else {
                    bridge.add(0);
                }
            }
        }
        System.out.println(time);
    }
}