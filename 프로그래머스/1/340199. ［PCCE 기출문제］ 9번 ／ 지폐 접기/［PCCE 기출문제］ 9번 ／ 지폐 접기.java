import java.util.*;

class Solution {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        // 2개 정렬
        Arrays.sort(wallet);
        Arrays.sort(bill);

        while (!fit(wallet, bill)) {
            bill[1] /= 2;
            Arrays.sort(bill);
            answer++;
        }
        return answer;
    }

    // 체크 함수
    public static boolean fit(int[] wallet, int[] bill) {
        
        return (bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
               (bill[0] <= wallet[1] && bill[1] <= wallet[0]);
        
    }
}