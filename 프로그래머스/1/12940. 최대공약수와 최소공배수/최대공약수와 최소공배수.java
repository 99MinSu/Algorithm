class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = m;
        int min = n;
        
        if(n > m){
            max = n;
            min = m;
        }
        
        for(int i = 1; i <= min; i++){
            if(min % i == 0 && max % i == 0){
                answer[0] = i;
            }
        }
        
        // 최소 공배수는 두수의 곱/ 최대공약수
        answer[1] = n * m / answer[0];
        
        return answer;
    }
}