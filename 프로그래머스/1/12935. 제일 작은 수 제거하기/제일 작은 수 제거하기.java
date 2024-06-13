class Solution {
    public int[] solution(int[] arr) {
                
        if(arr.length == 1){
            int[] answer = {-1};
            
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int min = arr[0];
            
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        
        for(int i = 0 , j = 0; i < arr.length; i++){
            if(arr[i] == min){
                continue;
            }
            answer[j++] = arr[i];
        }
        return answer;
    }
}