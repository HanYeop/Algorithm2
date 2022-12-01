import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 2805. 나무 자르기 (Java)
public class Main {
	
	static int n; // 나무의 수
	static long m; // 집으로 가져가려고 하는 나무의 길이
	static long[] tree; // 나무 정보
	static long max = Integer.MIN_VALUE; // 가장 큰 나무
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		tree = new long[n];
		
		// 나무 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			long cur = Long.parseLong(st.nextToken());
			tree[i] = cur;
			max = Math.max(max, cur);
		}
		
		long left = 0;
		long right = max;

		// 이분탐색
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			for(long l: tree) {
				
				// 잘라도 가져갈 수 있는 나무가 없는 경우
				if(l <= mid) {
					continue;
				}
				
				sum += l - mid;
			}
			
			// m이상 나무를 가져갈 수 있으면 더 높이 잘라봄
			if(sum >= m) {
				left = mid + 1;
			}
			// 나무 길이가 모자라면 더 낮게 잘라봄
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
}
