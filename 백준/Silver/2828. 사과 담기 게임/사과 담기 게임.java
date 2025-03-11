import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 스크린 크기
        int M = Integer.parseInt(st.nextToken()); // 바구니 크기

        int J = Integer.parseInt(br.readLine()); // 떨어지는 사과 개수

        // 바구니의 초기 위치
        int left = 1;
        int right = M;

        int moveDistance = 0;

        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < left) { // 바구니보다 왼쪽에 떨어지는 경우
                moveDistance += (left - apple);
                right -= (left - apple);
                left = apple;
            } else if (apple > right) { // 바구니보다 오른쪽에 떨어지는 경우
                moveDistance += (apple - right);
                left += (apple - right);
                right = apple;
            }
            // apple이 바구니 범위 안에 있으면 이동할 필요 없음
        }

        System.out.println(moveDistance);
    }
}
