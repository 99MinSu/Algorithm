import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Deque<String> q = new ArrayDeque<>();
        
        for (String city : cities) {
            city = city.toUpperCase(); 
            
            if (q.contains(city)) {
                q.remove(city);
                answer += 1;
            } else {
                if (q.size() >= cacheSize) {
                    q.poll(); 
                }
                answer += 5;
            }
            q.offer(city);
        }
        
        return answer;
    }
}