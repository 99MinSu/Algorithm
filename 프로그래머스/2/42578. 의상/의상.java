import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> h = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String type = clothes[i][1];
            if(h.containsKey(type)){
                h.put(type,h.get(type) + 1);
            }else{
                h.put(type,1);
            }
        }
        
        int answer = 1;
        for(int val : h.values()){
            answer *= (val+1);
        }
        
        return answer - 1;
    }
}