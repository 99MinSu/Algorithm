import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 

        for (int tc = 1; tc <= T; tc++) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr); 

            int sum = 0;
            for (int i = 1; i < 9; i++) { 
                sum += arr[i];
            }

          
            int avg = Math.round((float)sum / 8);

            System.out.println("#" + tc + " " + avg);
        }
    }
}
