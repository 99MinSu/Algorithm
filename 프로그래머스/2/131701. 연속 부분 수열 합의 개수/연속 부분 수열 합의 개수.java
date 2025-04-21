import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < elements.length ; i++){
            int num = 0;
            for(int j = 0 ; j < elements.length ; j++){
                num += elements[(i+j)%elements.length];
                set.add(num);
            }
        }
        return set.size();
    }
}