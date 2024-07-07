import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int[] arr = new int[strArr.length];
        
        for(int i = 0; i < strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[0]+" ").append(arr[strArr.length-1]);
        
        return answer = sb.toString();
    }
}