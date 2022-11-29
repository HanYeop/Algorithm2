import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1700. 멀티탭 스케줄링 (Java)
public class Main {
	
	static int n; // 멀티탭 구멍 수
	static int k; // 전기 용품 총 사용횟수
	static int count; // 플러그 빼는 회수
	static int[] name; // 전기용품 이름
	static Set<Integer> set; // 현재 꽂혀있는 전기용품
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		name = new int[k];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			name[i] = Integer.parseInt(st.nextToken());
		}
		
		solve();
		
		System.out.println(count);
	}
	
	static void solve() {
		for(int i = 0; i < k; i++) {
			int cur = name[i];
			
			// 이미 꽂혀있으면 꽂을 수 있음
			if(set.contains(cur)) {
				continue;
			}
			
			if(set.size() < n) {
				set.add(cur);
			}else {
				set.remove(find(i + 1));
				set.add(cur);
				count++;
			}
		}
	}
	
	// 가장 우선순위가 낮은 플러그 찾기
	static int find(int x) {
		HashSet<Integer> copySet = new HashSet<>();
		int result = 0;
		
		for(int i: set) {
			copySet.add(i);
		}
		
		for(int i = x; i < k; i++) {
			
			if(copySet.size() <= 1) {
				break;
			}
			
			copySet.remove(name[i]);
		}
		
		for(int i: copySet) {
			result = i;
		}
		
		return result;
	}
}
