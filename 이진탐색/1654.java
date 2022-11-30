import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// [백준] 1654. 랜선 자르기 (Java)
public class Main {
	
	static int n; // 필요한 랜선 수
	static int k; // 이미 가지고 있는 랜선 수
	static int max; // 가장 긴 랜선의 길이
	static ArrayList<Integer> cable; // 랜선 길이
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		cable = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			cable.add(Integer.parseInt(br.readLine()));
		}
		
		max = Collections.max(cable);
		
		// 최소 1 이상의 길이로 자르므로 시작은 1
		long left = 1;
		// 제일 긴 케이블보다 크게 자를 수 없음
		long right = max;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
            for (int i: cable) { 
                sum += (i / mid); // 자른 개수 합
            }
            // 크거나 같으면 자르는 길이를 늘려봄 
            if (sum >= n) {
                left = mid + 1;
            }
            // 모자라면 자르는 길이를 줄여봄
            else {
                right = mid - 1;
            }
		}
		
		System.out.println(right);
	}
}
