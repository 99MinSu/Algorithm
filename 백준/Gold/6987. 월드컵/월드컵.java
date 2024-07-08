import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean flag;
	static int[] team1 = new int[15];
	static int[] team2 = new int[15];
	static int[] win = new int[6];
	static int[] draw = new int[6];
	static int[] lose = new int[6];


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 6C2 = 15
		// 0,1,2,3,4,5 6개의 팀이 경기하는 경우의 수 = 조합이랑 같다
		// [0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4]
		// [1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5]
		// 총 2개의 팀이 30개의 승무패가 난다.
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				team1[idx] = i;
				team2[idx] = j;
				idx++;
			}

		}

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int sum = 0;
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());

				sum += win[j] + draw[j] + lose[j];
			}

			flag = false;
			if (sum == 30) dfs(0);

			// 출력
			if (flag) System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}

	} // end main

	static void dfs(int game) {
		if (flag) return; // 가지 치기

		// 15번 경기를 다 치뤘으면
		if (game == 15) {
			flag = true;
			return;
		}
 
		// 겨루는 나라 2개
		int t1 = team1[game];
		int t2 = team2[game];

		// t1 win
		if (win[t1] > 0 && lose[t2] > 0) {
			win[t1]--;
			lose[t2]--;
			dfs(game + 1); 
			win[t1]++;
			lose[t2]++;
		}

		// t1 draw t2
		if (draw[t1] > 0 && draw[t2] > 0) {
			draw[t1]--;
			draw[t2]--;
			dfs(game + 1);
			draw[t1]++;
			draw[t2]++;
		}

		// t1 lose
		if (lose[t1] > 0 && win[t2] > 0) {
			lose[t1]--;
			win[t2]--;
			dfs(game + 1);
			lose[t1]++;
			win[t2]++;
		}

	} // end dfs

}