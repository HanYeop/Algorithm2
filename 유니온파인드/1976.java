import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1976. 여행 가자 (Java)
public class Main {

    static int n; // 도시의 수
    static int m; // 여행 계획에 속한 도시들의 수
    static int[] parent; // 연결 그룹

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int adj = Integer.parseInt(st.nextToken());
                if(adj == 1){
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        for(int i = 1; i < m; i++){
            int next = Integer.parseInt(st.nextToken());
            if(find(start) != find(next)){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void union(int x, int y){
        int nx = find(x);
        int ny = find(y);

        if(nx != ny){
            parent[ny] = nx;
        }
    }

    static int find(int x){
        if(x == parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
}
