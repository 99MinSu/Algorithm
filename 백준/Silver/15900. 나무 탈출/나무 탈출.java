import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int totalDepth = 0;	//리프 노드 깊이의 합 저장하는 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for(int i=0;i<=N;i++) {
            tree.add(new ArrayList<>());
        }
        
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        search(0, 1, 0);	
        
        if(totalDepth%2==1)
            System.out.println("Yes");
        else
            System.out.println("No");    
    }

    static void search(int depth, int cur, int parent){
        boolean check = false;	
        //자식 노드 존재시 탐색
        for(int next : tree.get(cur)){
            if(parent != next){
                check = true;
                search(depth+1, next, cur);
            }
        }
        //리프 노드일 때 깊이 더하기
        if(!check)
            totalDepth += depth;
    }
}