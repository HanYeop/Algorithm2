import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 13549. 숨바꼭질 3 (Java)
class Point implements Comparable<Point>{
	int x, time;
	
	Point(int x, int time){
		this.x = x;
		this.time = time;
	}
	
	// 시간이 조금 걸리는 순서로 정렬
	@Override
	public int compareTo(Point o) {
		return this.time - o.time;
	}
}

public class Main {
	
	static int n; // 수빈이 시작 위치
	static int k; // 동생 위치
	static int MAX = 100000 + 1;
	static int[] visited; // 방문 여부
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new int[MAX];
		Arrays.fill(visited, Integer.MAX_VALUE);
		solve();
	}
	
	static void solve() {
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.offer(new Point(n,0));
		visited[n] = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
						
			// 찾으면 바로 종료. 최소
			if(cur.x == k) {
				System.out.println(cur.time);
				System.exit(0);
			}
			
			int multi = cur.x * 2;
			int next = cur.x + 1;
			int pre = cur.x - 1;
			int time = cur.time;
			
			if(isRange(multi) && time < visited[multi]) {
				q.offer(new Point(multi, cur.time));
				visited[multi] = time;
			}
			if(isRange(next) && time + 1 < visited[next]) {
				q.offer(new Point(next, cur.time + 1));
				visited[next] = time + 1;
			}
			if(isRange(pre) && time + 1 < visited[pre]) {
				q.offer(new Point(pre, cur.time + 1));
				visited[pre] = time + 1;
			}
			
//			if(isRange(pre) && time + 1 < visited[pre]) {
//				q.offer(new Point(pre, cur.time + 1));
//				visited[pre] = time + 1;
//			}
		}
	}
	
	// 범위 체크
	static Boolean isRange(int x) {
		if(x < 0 || x >= MAX) {
			return false;
		}else {
			return true;
		}
	}
}
