import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 필요한 기타줄 개수
        int M = Integer.parseInt(st.nextToken()); // 브랜드 개수

        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        // 최소 패키지 가격과 최소 낱개 가격을 찾음
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int singlePrice = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, packagePrice);
            minSingle = Math.min(minSingle, singlePrice);
        }

        // 1. 패키지 + 낱개 혼합
        int cost1 = (N / 6) * minPackage + (N % 6) * minSingle;
        // 2. 패키지만 구매
        int cost2 = ((N + 5) / 6) * minPackage; // 올림 효과 (N을 6으로 나누어 올림한 값)
        // 3. 낱개만 구매
        int cost3 = N * minSingle;

        // 최소 비용 계산
        System.out.println(Math.min(cost1, Math.min(cost2, cost3)));
    }
}
