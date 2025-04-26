class Solution {
    public int solution(String s) {
      int answer = 0;
		int t = 0, f = 0;
		char x = s.charAt(0);
		
		for(int i=0; i<s.length(); i++) {
			
			if(t==f) {
				answer++;
				x = s.charAt(i);
				System.out.println(x);
			} // 카운트보다 먼저 검사하는 것이 포인트!
			
			if(x == s.charAt(i)) t++;
			else f++;
		}
		return answer;
    }
}