import java.io.*;
import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>(); // 중복값 제거 위한 set
    static char[] arr; // 종이조각
    static boolean[] visited; // 사용여부
    
    public int solution(String numbers) {
        int answer = 0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i); 
        }
                
        dfs("",0); // 재귀함수
        
        answer = set.size();
        return answer;
    }
	//백트래킹
	static void dfs(String str, int idx) {
        int num;
            
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num); // 소수판별
        }
        if(idx==arr.length) return; // 끝까지 다했을 때 
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue; // 방문한 노드면 넘어감
            visited[i] = true; // 방문

            dfs(str+arr[i], idx+1); // 방문 했을 시 재귀

            visited[i] = false; // 백트래킹
        }
		
	}
    
	//소수 판단
	static boolean isPrime(int n) {
		if(n<2) return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}

}