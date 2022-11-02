import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 11052. 카드 구매하기 (Java)
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] card = new int[n + 1];
		int[] max = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			max[i] = card[i];
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = (i - 1); j > 0; j--) {
				max[i] = Math.max(max[i], max[j] + card[i - j]);
			}
		}
		
//		for(int i = 1; i < n + 1; i++) {
//			System.out.println(max[i]);
//		}
		System.out.println(max[n]);
	}
}