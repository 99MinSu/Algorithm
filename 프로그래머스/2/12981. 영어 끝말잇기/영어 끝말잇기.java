import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        // 끝 글자와 첫 글자 비교
        // 중복 비교

        HashSet<String> usedWords = new HashSet<>();
        usedWords.add(words[0]); 

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];    

            if (prevWord.charAt(prevWord.length() - 1) != currWord.charAt(0)) {
                answer[0] = i % n + 1; // 탈락한 사람 번호
                answer[1] = i / n + 1; // 탈락한 사람의 차례
                break;
            }

            if (usedWords.contains(currWord)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1; 
                break;
            }

            usedWords.add(currWord);
        }

        return answer;
    }
}