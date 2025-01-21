import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            // n번째 문자 비교
            if (a.charAt(n) == b.charAt(n)) {
                // n번째 문자가 같다면 사전순 비교
                return a.compareTo(b);
            }
            // n번째 문자를 기준으로 비교
            return Character.compare(a.charAt(n), b.charAt(n));
        });
        return strings;
    }
}