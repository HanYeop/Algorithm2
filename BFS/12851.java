import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 12851. 숨바꼭질 2 (Java)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int size = 100000 + 1;
		int time = Integer.MAX_VALUE;
		int count = 0;
		
		// 최소로 도달할 수 있는지
		int[] map = new int[size];
		for(int i = 0; i < size; i++) {
			map[i] = Integer.MAX_VALUE;
		}
		map[n] = 0; // 시작 위치 0
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		
		
		int level = 0; // 큐 레벨
		
		while(!q.isEmpty()) {
			int qSize = q.size(); // 현재 레벨의 큐 사이즈
			
			for(int i = 0; i < qSize; i++) {
				int poll = q.poll();
				
				if(level > time) {
					break;
				}
				
				// 답 찾았을 때
				if(poll == k ) {
					time = level;
					count++;
					continue;
				}
				
				// 현재 레벨이 최소보다 작을 때
				if(poll + 1 < size) {
					if(level < map[poll + 1]) {
						map[poll + 1] = level + 1;
						q.offer(poll + 1);
					}
				}
				
				// 현재 레벨이 최소보다 작을 때
				if(poll - 1 >= 0) {
					if(level < map[poll - 1]) {
						map[poll - 1] = level + 1;
						q.offer(poll - 1);
					}
				}
				
				// 현재 레벨이 최소보다 작을 때
				if(poll * 2 < size) {
					if(level < map[poll * 2]) {
						map[poll * 2] = level + 1;
						q.offer(poll * 2);
					}
				}
			}
			level++;
		}
		
		System.out.println(time);
		System.out.println(count);
	}
}
