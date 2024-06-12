class Solution {
    public String solution(int n) {
        String answer = "";
        String[] s = {"수", "박"};
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                answer += s[0];
            }
            else
                answer += s[1];
        }
        return answer;
    }
}