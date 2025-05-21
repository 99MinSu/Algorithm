import java.io.*;
import java.util.*;

public class Solution {
    static final String[] nums = {
        "ZRO", "ONE", "TWO", "THR", "FOR",
        "FIV", "SIX", "SVN", "EGT", "NIN"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tc = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            int[] count = new int[10]; 

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String word = st.nextToken();
                for (int j = 0; j < 10; j++) {
                    if (nums[j].equals(word)) {
                        count[j]++;
                        break;
                    }
                }
            }

            System.out.println(tc);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        }

    }
}
