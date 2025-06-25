class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 구현
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            
            for (int i = start; i <= n; i++) {
                sum += i;
                if (sum == n) {
                    answer++; 
                    break;
                } else if (sum > n) {
                    break; 
                }
            }
        }
        
        return answer;
    }
}