import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 11726. 2×n 타일링 (Java)
public class Main {

    static int n;
    static long[] dp;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        result = solve(n);

        System.out.println(result);
    }

    static long solve(int x){
        if(x <= 1) return dp[x] = 1;
        if(dp[x] != 0) return dp[x];

        return dp[x] = (solve(x - 2) + solve(x - 1)) % 10007;
    }
}
