import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1806. 부분합 (Java)
public class Main {
	static int n; // 수열 길이
	static int[] arr; // 수열
	static int min = Integer.MAX_VALUE; // 최소의 길이
	static long s; // 구해야하는 부분합
	static int start; // 시작점
	
	static int count = 1; // 현재 길이
	static long sum; // 현재 부분합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Long.parseLong(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			// 더 작으면 더해줌
			sum += arr[i];
			count++;	
			
			while(sum >= s) {
				sum -= arr[start++];
				count--;
				min = Math.min(min, count);
			}
		}
		
		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}
}