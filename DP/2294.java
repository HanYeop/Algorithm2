import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2294. 동전 2 (Java)
public class Main {
	
	static int n;
	static int k;
	static int MAX = 100000 + 1;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[MAX];
		
		// 배열 최대값으로 초기화
		for(int i = 1; i < MAX; i++) {
			dp[i] = MAX;
		}
	
		for(int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			arr[i] = cur;
			dp[cur] = 1;
		}
		
		solve();
		
		if(dp[k] == MAX) {
			dp[k] = -1;
		}
		
		System.out.println(dp[k]);
	}
	
	// 1부터 k 까지 만들 수 있는 최소값을 찾음
	static void solve() {
		for(int i = 1; i <= k; i++) {
			for(int j: arr) {
				// 범위 벗어나는 경우
				if(i < j) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
			}
		}
	}
}
