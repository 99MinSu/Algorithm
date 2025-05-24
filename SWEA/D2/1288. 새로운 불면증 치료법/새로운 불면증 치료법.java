import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            Set<Character> seenDigits = new HashSet<>();
            int multiplier = 0;
            int current = 0;

            while (seenDigits.size() < 10) {
                multiplier++;
                current = N * multiplier;
                for (char ch : String.valueOf(current).toCharArray()) {
                    seenDigits.add(ch);
                }
            }

            sb.append("#").append(t).append(" ").append(current).append("\n");
        }

        System.out.print(sb);
    }
}