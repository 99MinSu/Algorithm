import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String arr[] = new String[n];
		String temp[] = new String[n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			arr[i] = str;
			temp[i] = str;
		}

		Arrays.sort(temp);

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (!arr[i].equals(temp[i])) {
				flag = true;
				break;
			}
		}

		if (!flag)
			System.out.println("INCREASING");
		else {
			Arrays.sort(temp, Collections.reverseOrder());
			flag = false;

			for (int i = 0; i < n; i++) {
				if (!arr[i].equals(temp[i])) {
					flag = true;
					break;
				}
			}

			if(!flag)
				System.out.println("DECREASING");
			else
				System.out.println("NEITHER");
		}
	}
}