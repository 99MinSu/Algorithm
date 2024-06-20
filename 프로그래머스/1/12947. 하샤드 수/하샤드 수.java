class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String s = Integer.toString(x);
        
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++){
            sum += s.charAt(i) - '0';
        }
        
        System.out.println(sum);
        
        if(x % sum  != 0){
            answer = false;
        }

        
        return answer;
    }
}