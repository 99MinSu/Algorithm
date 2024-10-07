class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int map = brown + yellow; // 카펫 넓이
        
        for(int i = 3; i < map; i++){
            int x = map / i; // 가로길이
            
            if(x >= i){
                if(( x - 2) * (i - 2) == yellow){
                    answer[0] = x;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}