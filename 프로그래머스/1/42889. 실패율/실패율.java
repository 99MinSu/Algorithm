import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] staying = new int[N + 2];  // 각 스테이지에 머물러 있는 유저 수
        int[] reached = new int[N + 2];  // 각 스테이지에 도달한 유저 수

        for (int stage : stages) {
            staying[stage]++;
        }

        for (int i = N + 1; i >= 1; i--) {
            reached[i] = staying[i] + (i == N + 1 ? 0 : reached[i + 1]);
        }

        // 실패율 계산
        List<Stage> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (reached[i] == 0) {
                stageList.add(new Stage(i, 0));
            } else {
                double failureRate = (double) staying[i] / reached[i];
                stageList.add(new Stage(i, failureRate));
            }
        }

        stageList.sort((a, b) -> {
            if (b.failureRate != a.failureRate) {
                return Double.compare(b.failureRate, a.failureRate);
            } else {
                return Integer.compare(a.stageNumber, b.stageNumber);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNumber;
        }

        return answer;
    }

    class Stage {
        int stageNumber;
        double failureRate;

        Stage(int stageNumber, double failureRate) {
            this.stageNumber = stageNumber;
            this.failureRate = failureRate;
        }
    }
}
