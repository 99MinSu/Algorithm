class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        int N = right - left + 1;
            
        for(int i = 0; i < N; i++){
            
            int count = 0;
            for(int j = 1; j <= left; j++){
                if(left % j == 0){
                    count++;
                }
            }
            if(count % 2 == 0){
                answer += left;
            }
            else{
                answer -= left;
            }
            left++;
        }
        return answer;
    }
}