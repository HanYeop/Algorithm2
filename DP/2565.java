import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2565. 전깃줄 (Java)
class Pair implements Comparable<Pair>{
    int a,b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair o) {
        return this.a - o.a;
    }
}

public class Main {

    static int n;
    static Pair[] arr;
    static int[] dp;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Pair[n];
        dp = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(a,b);
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            result = Math.max(recur(i), result);
        }

        System.out.println(n - result);
    }

    static int recur(int x) {
        // 탐색하지 않았던 위치라면
        if(dp[x] == 0) {
            dp[x] = 1;
            // A의 N번째와 이후의 전봇대들 비교
            for(int i = x + 1; i < dp.length; i++) {
                if(arr[x].b < arr[i].b) {
                    // 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장
                    dp[x] = Math.max(dp[x], recur(i) + 1);
                }
            }
        }
        return dp[x];
    }
}
