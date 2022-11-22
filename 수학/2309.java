import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2309. 일곱 난쟁이 (Java)
public class Main {
	static int[] list;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new int[9];
		result = new ArrayList<Integer>();
		
		for(int i = 0; i < 9; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0, 0, 0);
	}
	
	static void combi(int index, int count, int sum) {
		// 키가 100을 넘어가면 더이상 탐색x
		if(sum > 100) {
			return;
		}
		
		// 일곱 난쟁이 다 찾음
		if(count == 7) {
			// 키의 합이 100일 때 정답
			if(sum == 100) {
				Collections.sort(result);
				for(int i: result) {
					System.out.println(i);
				}
				System.exit(0);
			}
			return;		}
		
		for(int i = index; i < 9; i++) {
			result.add(list[i]);
			combi(i + 1, count + 1, sum + list[i]);
			result.remove(result.size() - 1);
		}
	}
}





