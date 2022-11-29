import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1463. 1로 만들기 (Java)
class Point {
	int x,count;
	
	Point(int x, int count){
		this.x = x;
		this.count = count;
	}
}
public class Main {
	
	static int n; // 정수 n
	static int MAX = 1000000;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		visited = new int[n];
		
		Arrays.fill(visited, Integer.MAX_VALUE);
		solve();
		
//		System.out.println(Arrays.toString(visited));
		if(n == 1) System.out.println(0);
		else System.out.println(visited[1]);
	}
	
	static void solve() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(n,0));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int count = cur.count + 1;
			
			if(!isRange(x)) {
				continue;
			}
			
			if(x % 3 == 0 && count < visited[x / 3]) {
				q.offer(new Point(x / 3, count));
				visited[x / 3] = count;
			}
			
			if(x % 2 == 0 && count < visited[x / 2]) {
				q.offer(new Point(x / 2, count));
				visited[x / 2] = count;
			}
			
			if(count < visited[x - 1]) {
				q.offer(new Point(x - 1, count));
				visited[x - 1] = count;
			}
		}
	}
	
	static boolean isRange(int x) {
		if(x < 1 || x > MAX) {
			return false;
		}else {
			return true;
		}
	}
}
