class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] lang = {"aya", "ye", "woo", "ma"};
        
        for (int i=0;i<babbling.length;i++) {
            String word = babbling[i]; // 첫 단어 담아줌
            boolean check = true; // 발음 가능한 지 체크
            
            for (int j = 0; j < lang.length; j++) {
                if (word.contains(lang[j] + lang[j])) { // 연속된 발음 체크
                    check = false;
                    break;
                }
            }
            
            if (!check) continue; // 불가능한 발음이면 넘어감
            
            for (String babble : lang) {
                word = word.replace(babble, " "); // 공백으로 만들어줌
            }
            
            if (word.trim().isEmpty()) { // trim()을 통해 공백 제거
                answer++;
            }
        }
        
        return answer;
    }
}