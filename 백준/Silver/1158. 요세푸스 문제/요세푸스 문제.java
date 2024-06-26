import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> qu = new LinkedList<>(); // 큐 생성 // ArrayDeque 로 생성해 주는 것이 좋다

        for (int i = 1; i <= n; i++) { // 큐에 1부터 n 까지 순서대로 넣어주기
        	qu.offer(i); 
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("<");
        
        while (qu.size() != 1) {
        	for (int i = 0; i < k - 1; i++) { // k 번 전까지 빼서 다시 널어주고
        		qu.offer(qu.poll());
        		}
        
        		sb.append(qu.poll()).append(", "); // k 번 째 수 더해주고 ,까지 더하기
        }
        // 하나 남은 값 빼와서 합치기        
        sb.append(qu.poll()).append(">");
        System.out.println(sb);
    }      
}

// 덱으로 푸는 게 속도가 빠르다 앞으로 덱으로 풀기
    // static int N, K;
    // static Queue<Integer> queue = new ArrayDeque<>();
    // static StringBuilder sb = new StringBuilder();
    // public static void main(String[] args) throws Exception{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     N = Integer.parseInt(st.nextToken());
    //     K = Integer.parseInt(st.nextToken());
        
    //     // 번호를 채우고
    //     for (int i = 1; i <= N; i++) {
    //         queue.offer(i);
    //     }
        
    //     // 풀이
    //     int aliveCnt = 1; // 살아 있는 번호에서만 증가 <= K 번째를 판단
        
    //     sb.append("<");
    //     while( ! queue.isEmpty() ) {
    //         int num = queue.poll();
            
    //         if( ( aliveCnt % K ) == 0 ) {
    //             sb.append(num).append(", ");
    //         }else {
    //             queue.offer(num);
    //         }
    //         aliveCnt++;
    //     }
        
    //     sb.setLength(sb.length() - 2);
    //     sb.append(">");
    //     System.out.println(sb);
    // }

// 배열로 풀기 ( 다른 것보다 빠르다 )
	// static int N, K;
	// static int[] input;
	// static StringBuilder sb = new StringBuilder();
	// public static void main(String[] args) throws Exception{
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	StringTokenizer st = new StringTokenizer(br.readLine());
	// 	N = Integer.parseInt(st.nextToken());
	// 	K = Integer.parseInt(st.nextToken());
		
	// 	input = new int[N + 1]; // 출력 번호 1 시작 : 0 dummy;
		
	// 	// 번호 채우고, 죽으면 0으로 변경
	// 	for (int i = 1; i <= N; i++) {
	// 		input[i] = i;
	// 	}
		
	// 	int deathCnt = 0; // 죽은 사람의 수 모두 죽으면 종료
	// 	int idx = 1; // 죽은 사람 포함하는 뱌열 순회
	// 	int aliveCnt = 1; // 살아 있는 번호에서만 증가
		
	// 	sb.append("<");
		
	// 	while(true) {
	// 		if( deathCnt == N) break; // 모두 죽으면 종료
			
	// 		// 살아 있는 사람의 K 번째 선택 죽인다.
	// 		if(input[idx] != 0) { // 살아있는 사람에 대해서만 따진다.
	// 			if( (aliveCnt % K) == 0) { // 살아있는 사람 중에 K 번째
	// 				sb.append(input[idx]).append(", ");
	// 				input[idx] = 0; // 죽음으로 표시
	// 				deathCnt++;
	// 			}
	// 			aliveCnt++;
	// 		}
			
	// 		idx++; // 항상 증가
	// 		if( idx > N ) idx = 1;
	// 	}
	// 	sb.setLength(sb.length() - 2); // 뒤에 잘라주기
	// 	sb.append(">");
	// 	System.out.println(sb);
	// }
