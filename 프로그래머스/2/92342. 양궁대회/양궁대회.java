public class Solution {
    // 점수 차가 최대일 때 라이언이 쏜 화살 배열을 저장하는 변수
    static private int[] res = new int[11];
    // 최종 정답 배열 (라이언의 최적 화살 분배)
    static private int[] lion = {-1};
    static private int max = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info) {
        // DFS를 사용하여 모든 경우의 수 탐색
        dfs(0, n, info);
        
        // 라이언이 어피치를 이길 수 없는 경우
        if (max == -1) {
            lion = new int[1];
            lion[0] = -1;
        }
        return lion;
    }

    // DFS를 이용한 백트래킹 함수
    public static void dfs(int depth, int n, int[] info) {
        // 종료 조건: 모든 화살을 다 쏜 경우
        if (depth == n) {
            // 현재 화살 분배로 점수 차 계산
            int diff = score(info);
            // 점수 차가 최대값을 갱신하는 경우
            if (max <= diff) {
                max = diff; // 최대 점수 차 갱신
                lion = res.clone(); // 현재 화살 분배 저장
            }
            return;
        }
        
        // 각 과녁 점수에 화살을 배치
        for (int i = 0; i < info.length && res[i] <= info[i]; i++) {
            res[i] += 1; // 화살을 해당 점수에 추가
            dfs(depth + 1, n, info); // 재귀 호출
            res[i] -= 1; // 화살 배치를 되돌림 (백트래킹)
        }
    }

    // 점수 계산 함수
    public static int score(int[] info) {
        int apeach = 0, lion = 0;
        for (int i = 0; i < res.length; i++) {
            // 어피치와 라이언 모두 화살을 쏘지 않은 경우
            if (info[i] == 0 && res[i] == 0) continue;
            // 어피치가 더 많은 화살을 맞힌 경우
            if (info[i] >= res[i]) {
                apeach += (10 - i); // 어피치가 해당 점수를 얻음
            } else {
                lion += (10 - i); // 라이언이 해당 점수를 얻음
            }
        }
        
        // 점수 차 계산
        int diff = lion - apeach;
        // 라이언이 점수가 낮거나 비기는 경우
        if (diff <= 0) return -1;
        return diff; // 라이언이 더 높은 점수 차
    }
}
