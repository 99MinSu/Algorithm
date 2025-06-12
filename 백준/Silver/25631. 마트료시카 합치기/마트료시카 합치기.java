import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		int n = Integer.parseInt(br.readLine());

		int [] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		TreeMap<Integer,Integer> hm = new TreeMap<>();

		for(int num : arr){
			hm.put(num, hm.getOrDefault(num, 0)+1);
		}

        int maxFreq = 0;
        int result = 0;

        for (int count : hm.values()) {
            if (count > maxFreq) {
                maxFreq = count;
                result = count;
            }
        }

		System.out.println(result);
	}
}