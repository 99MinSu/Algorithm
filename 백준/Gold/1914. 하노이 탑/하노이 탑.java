import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

   static int N;
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      
      BigInteger move = BigInteger.valueOf(2).pow(N).subtract(BigInteger.valueOf(1));
      sb.append(move).append("\n");
      if(N <= 20) {
         hanoi(N, 1, 2, 3);
      }
      System.out.println(sb);
   }

   static void hanoi(int n, int from, int temp, int to) {
      if(n == 0) return;
      
      hanoi(n-1, from, to, temp);
      sb.append(from).append(" ").append(to).append("\n");
      hanoi(n-1, temp, from, to);
   }
}