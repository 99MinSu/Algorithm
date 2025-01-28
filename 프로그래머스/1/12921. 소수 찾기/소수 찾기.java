class Solution {
    public int solution(int n) {
    	// 2는 소수이기 때문에 초기값 1로 선언
        int answer = 1;
        
        // 3부터 n까지 반복하여 소수의 개수 찾기
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) answer += 1;
        }
        
        return answer;
    }
    
    private boolean isPrime(int num) {
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}