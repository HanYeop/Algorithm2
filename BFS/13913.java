import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 13913. 숨바꼭질 4 (Java)
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
	static int[] route;
	static ArrayList<Integer> list;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new int[MAX];
		route = new int[MAX];
		list = new ArrayList<>();
		
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		solve();
		a();
		
		System.out.println(visited[k]);

		StringBuilder sb = new StringBuilder();
		for(int i: list) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
	
	static void a() {
		int start = k;		
		while(true) {
			if(start == n) {
				break;
			}
			list.add(start);
			start = route[start];
		}
		list.add(n);
		Collections.reverse(list);
	}
	
	static void solve() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(n,0));
		visited[n] = 0;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			int multi = cur.x * 2;
			int next = cur.x + 1;
			int pre = cur.x - 1;
			int time = cur.time + 1;
			
			if(cur.x == k) {
				break;
			}
			
			if(isRange(multi) && time < visited[multi]) {
				pq.offer(new Point(multi, time));
				visited[multi] = time;
				route[multi] = cur.x;
			}
			if(isRange(pre) && time < visited[pre]) {
				pq.offer(new Point(pre, time));
				visited[pre] = time;
				route[pre] = cur.x;
			}
			if(isRange(next) && time < visited[next]) {
				pq.offer(new Point(next, time));
				visited[next] = time;
				route[next] = cur.x;
			}
		}
	}
	
	static boolean isRange(int x) {
		if(x < 0 || x >= MAX) {
			return false;
		}else {
			return true;
		}
	}
}
