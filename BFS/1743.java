import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1743. 음식물 피하기 (Java)
class Point{
	int x,y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int n; // 세로 길이
	static int m; // 가로 길이
	static int k; // 음식물 쓰레기 개수
	static int[][] map; // 통로
	static int max = Integer.MIN_VALUE; // 가장 큰 음식물 개수
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 범위 0부터 시작하도록
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			map[x][y] = 1;
		}
		
		// 전체 BFS 탐색
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				// 방문하지 않은 곳만 탐색
				if(!isVisited(i, j)) {
					solve(new Point(i,j));
				}
			}
		}
		
		System.out.println(max);
	}
	
	// BFS
	static void solve(Point po) {
		
		Queue<Point> q = new LinkedList<Point>();
		q.offer(po);
		map[po.x][po.y] = 0; // 방문 처리
		
		int count = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			count++;
			
			for(int i = 0; i < 4; i++) {
				
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 범위를 벗어난다면
				if(!isRange(nx, ny)) {
					continue;
				}
				
				// 이미 방문 했다면 
				if(isVisited(nx, ny)) {
					continue;
				}
				
				q.offer(new Point(nx, ny));
				map[nx][ny] = 0; // 방문 처리
			}
		}
		
		max = Math.max(max, count);
	}
	
	// 범위 체크
	static Boolean isRange(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m) {
			return false;
		}else {
			return true;
		}
	}
	
	// 방문 체크 (0은 방문한 것으로 해석한다)
	static Boolean isVisited(int x, int y) {
		if(map[x][y] == 0) {
			return true;
		}else {
			return false;
		}
	}
}
