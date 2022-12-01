import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [백준] 5972. 택배 배송 (Java)
public class Main {
	
	static class Point implements Comparable<Point>{
		int des, value;
		
		Point(int des, int value){
			this.des = des;
			this.value = value;
		}
		
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	static int n; // 헛간 수
	static int m; // 소들의 길
	static ArrayList<Point>[] map; // 지도
	static int[] dist; // 최소 경로
	static int max = 1000 + 1; // 소 최대
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		dist = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			map[i] = new ArrayList<Point>();
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 맵 생성
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			map[n1].add(new Point(n2, value));
			map[n2].add(new Point(n1, value));
		}
		
		solve();
		System.out.println(dist[n]);
	}
	
	static void solve() {
		
		PriorityQueue<Point> pq = new PriorityQueue<>();

		pq.add(new Point(1,0));
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			
			Point cur = pq.poll();
			
			int des = cur.des;
			int value = cur.value;
			
			if(value != dist[des]) {
				continue;
			}
			
			for(Point po : map[des]) {
				
				int nextValue = po.value + value;
				
				if(nextValue >= dist[po.des]) {
					continue;
				}
				
				dist[po.des] = nextValue; 
				pq.offer(new Point(po.des, nextValue));
			}
		}
	}
}
