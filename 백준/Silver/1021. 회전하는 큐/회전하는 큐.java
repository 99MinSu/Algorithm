import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        for(int i = 0; i < m; i++) {
            int target = dq.indexOf(num[i]);

            int half = dq.size() / 2;

            if(target <= half) {
                for(int j = 0; j < target; j++) {
                    dq.offerLast(dq.pollFirst());
                    count++;
                }
            }else{

                for(int j = 0; j < dq.size() - target; j++) {
                    dq.offerFirst(dq.pollLast());
                    count++;
                }
            }
            dq.poll();
        }

        System.out.println(count);
    }
}