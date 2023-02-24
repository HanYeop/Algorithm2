import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 15650. N과 M (2) (Java)
public class Main {
    static int n;
    static int m;
    static StringBuilder sb;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        sb = new StringBuilder();

        permutation(0, 1);
        System.out.println(sb);
    }

    static void permutation(int count, int cur){
        if(count == m){
            for(int i = 0; i < result.length; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = cur; i <= n; i++){
            result[count] = i;
            permutation(count + 1, i + 1);
        }
    }
}
