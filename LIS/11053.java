import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 11053. 가장 긴 증가하는 부분 수열 (Java)
public class Main {

    static int n;
    static int[] a;
    static int[] dp;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        dp = new int[n];

        // 시작점 초기화
        dp[0] = 1;

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 수열 길이 구하기
        for(int i = 1; i < n; i++){
            int value = 0;

            // 현재 위치보다 이전 값들 탐색
            for(int j = 0; j < i; j++){

                // 현재 위치값보다 값이 작고, dp 값보다 값이 크다면 포함시킴
                if(a[i] > a[j] && value < dp[j]){
                    value = dp[j];
                }
            }

            // 자기 자신 포함하므로 +1
            dp[i] = value + 1;
        }

        for (int i: dp){
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}