class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        String s = "";
        
        for(int i = 0; i < t.length() - p.length() + 1; i++){
            s = t.substring(i,i+p.length());
            if(Long.parseLong(s) <= Long.parseLong(p)){
                answer++;
            }           
        }
        return answer;
    }
}