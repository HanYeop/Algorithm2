import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 10974. 모든 순열 (Java)
public class Main4 {

    static int n;
    static int[] arr;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sb = new StringBuilder();
        visited = new boolean[n + 1];

        per(0);
        System.out.println(sb);
    }

    static void per(int count){
        // 순열 완성
        if(count == n){
            for(int i = 0; i < n; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(visited[i]){
                continue;
            }
            arr[count] = i;
            visited[i] = true;
            per(count + 1);
            visited[i] = false;
        }
    }
}
