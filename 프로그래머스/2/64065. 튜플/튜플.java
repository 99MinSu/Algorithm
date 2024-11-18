import java.util.*; // Map, List 등의 컬렉션 클래스 사용을 위해 import

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        // 입력 문자열의 양 끝 "{{"와 "}}"를 제거하여 숫자 집합 문자열만 남김
        s = s.substring(2, s.length() - 2);
        
        // 각 튜플 집합을 분리: "},{를 기준으로 문자열을 나눔
        String[] arr = s.split("\\},\\{");
        
        // 숫자와 등장 횟수를 저장하기 위한 Map
        Map<String, Integer> map = new HashMap<>();
        
        // 분리된 튜플 문자열을 순회
        for (String str : arr) {
            // 튜플 내의 숫자들을 분리
            String[] numArr = str.split(",");
            for (String num : numArr) { 
                // 숫자의 등장 횟수를 Map에 저장 (기본값 0에서 1 증가)
                map.put(num, map.getOrDefault(num, 0) + 1);    
            }            
        }
        
        // Map의 키(숫자)를 List로 변환
        List<String> keyList = new ArrayList<>(map.keySet());
        
        // 등장 횟수를 기준으로 숫자 정렬: 등장 빈도가 높은 순서대로 내림차순 정렬
        keyList.sort((s1, s2) -> map.get(s2) - map.get(s1));
        
        // 정렬된 숫자들을 배열로 변환
        answer = new int[keyList.size()];
        for (int i = 0; i < answer.length; i++) {
            // keyList는 문자열이므로, 정수 배열에 넣기 위해 Integer로 변환
            answer[i] = Integer.parseInt(keyList.get(i));
        }
        
        // 최종 결과 반환
        return answer;
    }
}
