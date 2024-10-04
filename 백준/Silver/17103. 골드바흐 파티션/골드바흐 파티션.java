import java.util.Scanner;

public class Main {
	static boolean num[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 소수 구하기 => 소수는 false
		num = new boolean[1000001];
		num[0] = num[1] = true;
		for (int i = 2; i * i <= 1000000; i++) {
			if (!num[i]) { // 소수를 찾으면
				for (int j = i + i; j <= 1000000; j += i) {
					num[j] = true; // 그 배수들은 소수가 아니다
				}
			}
		}
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int temp = sc.nextInt();
			int ans = 0;

			for (int j = 2; j <= temp / 2; j++) {
				if (!num[j] && !num[temp - j])
					ans++;
			}

			System.out.println(ans);
		}
	}
}