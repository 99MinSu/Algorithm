import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. 커스텀 정렬: (b+a).compareTo(a+b)
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 3. 0이 여러 개 있을 경우 "0000..."이 아닌 "0"으로 리턴
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }

        return answer.toString();
    }
}
