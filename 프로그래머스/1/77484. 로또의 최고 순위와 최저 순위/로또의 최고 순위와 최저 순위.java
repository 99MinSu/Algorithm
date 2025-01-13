class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int zeroCnt = 0;
        
        for(int i =0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCnt++;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
        }
        
        answer[0] = cnt == 0 && zeroCnt == 0 ? 6 : 7 - cnt - zeroCnt;
        answer[1] = cnt <= 1 ? 6 : answer[0] + zeroCnt;
        
        return answer;
    }
}