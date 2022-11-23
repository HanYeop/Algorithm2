package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2470. 두 용액 (Java)
public class Algorithm {
	
	static int n; // 용액 수
	static Long[] arr; // 용액 특성값
	static Long min = Long.MAX_VALUE; // 0에 가장 가까운지
	static Long one; 
	static Long two;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new Long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n - 1; i++) {
			solve(i, i + 1, n - 1);
		}
		
		Arrays.binarySearch(arr, 5);
		
		System.out.println(one + " " + two);
	}
	
	static void solve(int start, int low, int high) {
		
		int mid = (low + high) / 2; // 가운데 인덱스
		
		if(low > high) {
			return;
		}
		
		
		Long cur = arr[start] + arr[mid];

		// 0에 더 가깝다면
		if(Math.abs(cur) < min) {
			min = Math.abs(cur);
			one = arr[start];
			two = arr[mid];
		}
		
		// 정답 찾음
		if(cur == 0) {
			System.out.println(arr[start] + " " + arr[mid]);
			System.exit(0);
		}
		
		// 완쪽
		if(cur > 0) {
			solve(start, low, mid - 1);
		}
		// 오른쪽
		else {
			solve(start, mid + 1, high);
		}
	}
}