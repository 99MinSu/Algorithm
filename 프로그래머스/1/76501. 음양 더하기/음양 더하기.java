class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        int answer = 0;
                    
        int sum = 0;
        
        for(int i = 0; i < signs.length; i++){
            int x = 0;
            if(signs[i] == false){
                x = absolutes[i]; 
                absolutes[i] = -x;
            } 
        }
        
        for(int i = 0; i < absolutes.length; i++){
            sum += absolutes[i];            
        }
        
        return sum;
    }
}