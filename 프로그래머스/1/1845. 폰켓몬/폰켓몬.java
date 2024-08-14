import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length/2;
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }
        int answer = 0;
        
        if(hs.size() >= n){
            answer = n;
        }else
            answer = hs.size();
        
        return answer;
    }
}