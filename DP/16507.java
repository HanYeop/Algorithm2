import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 16507. 어두운 건 무서워 (Java)
public class Main {

    static int r,c,q;
    static int[][] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        dp = new int[r + 1][c + 1];
        sb = new StringBuilder();

        for(int i = 1; i <= r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= c; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int num = (x2 - x1 + 1) * (y2 - y1 + 1);
            int result = (dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) / num;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
