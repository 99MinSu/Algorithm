import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
             
            Queue<Integer> q =  new LinkedList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
             
            int dec = 1;
            while (true) {
                int front = q.poll() - dec;
                if (front <= 0) {
                    q.offer(0);
                    break;
                } else {
                    q.offer(front);
                }

                dec++;
                if (dec > 5) dec = 1; 
            }
            
            System.out.print("#" + N + " ");
            
            while(!q.isEmpty()) {
            	System.out.print(q.poll() + " ");
            }
            
            System.out.println();
        }
    }
}
