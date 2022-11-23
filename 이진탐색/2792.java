import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2792. 보석 상자 (Java)
public class Main {
	static int n; // 아이들 수
	static int m; // 색상 수
	static int low = 1;
	static int high;
	static int[] arr; // 각각의 보석 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		high = arr[arr.length - 1];
		
		while(low <= high) {
			int mid = (low + high) / 2; // 몇개 줄지 결정
			int sum = 0;
			
			for(int i = 0; i < m; i++) {
				if(arr[i] % mid == 0) {
					sum += arr[i] / mid;
				}else {
					sum += arr[i] / mid + 1;
				}
			}
		
			// 왼쪽 (만족한다면 한 사람에게 더 적은 보석을 줘야한다.
			if(sum <= n) {
				high = mid - 1;
			}
			// 오른쪽 (초과했다면 한 사람에게 더 많은 보석을 줘야한다.)
			else if(sum > n) {
				low = mid + 1;
			}
		}
		System.out.println(high + 1);
	}
}
