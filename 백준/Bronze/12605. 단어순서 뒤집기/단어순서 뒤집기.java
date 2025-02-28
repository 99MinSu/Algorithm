import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<String> word =new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            String[] temp = w.split(" ");
            for (int j = 0; j < temp.length; j++) {
                word.push(temp[j]);
            }
            sb.append("Case #" + (i+1) + ": ");
            for (int j = 0; j < temp.length; j++) {
                sb.append(word.pop()).append(" ");
            }
            sb.append('\n');

        }
        System.out.println(sb);
    }
}