import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int[] count = new int[10]; 

        for (char c : number.toCharArray()) {
            int digit = c - '0';
            count[digit]++;
        }

        // 6과 9는 서로 바꿔 쓸 수 있으므로 묶어서 처리
        int sixNine = count[6] + count[9];
        int sixNineSet = (sixNine + 1) / 2; // 올림처리

        count[6] = sixNineSet;
        count[9] = sixNineSet;

        int maxSet = 0;
        for (int i = 0; i < 10; i++) {
            maxSet = Math.max(maxSet, count[i]);
        }

        System.out.println(maxSet);
    }
}
