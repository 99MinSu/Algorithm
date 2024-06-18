import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        for(String a : str)
           answer += a;
        
        return answer;
    }
}

// 다른 사람 풀이
// class Solution {
//     public String reverseStr(String str){
//         char[] sol = str.toCharArray();
//     Arrays.sort(sol);
//     return new StringBuilder(new String(sol)).reverse().toString();
//     }
// }
