import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> mapX = new HashMap<>();
        for (char c : X.toCharArray()) {
            mapX.put(c, mapX.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> mapY = new HashMap<>();
        for (char c : Y.toCharArray()) {
            mapY.put(c, mapY.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder answer = new StringBuilder();
        for (Character keyX : mapX.keySet()) {
            for (Character keyY : mapY.keySet()) {
                if (keyX == keyY) {
                    int n  = (int) Math.min(mapX.get(keyX), mapY.get(keyY));
                    answer.append(keyX.toString().repeat(n));
                }
            }
        }
        
        answer.reverse();
        if (answer.toString().isEmpty()) return "-1";
        if (answer.toString().charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}