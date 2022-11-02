import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
	int x,y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
// [백준] 17141. 연구소 2 (Java)
public class Main {
	
	static int n; // 연구소 크기
	static int m; // 바이러스 개수
	static int min; // 전부 감염 최소 시간
	static int blank; // 빈칸 개수
	static int[][] map; // 연구소 맵
	static ArrayList<Pair> list = new ArrayList<>(); // 바이러스 가능 위치
	
	// 상우하좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 0) {
					blank++;
				}
				// 바이러스 놓을 수 있는 곳 표시
				else if(map[i][j] == 2) {
					list.add(new Pair(i,j));
				}
			}
		}
		
		combi(0, 0, new Pair[m]);
		
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	// BFS
	static void bfs(Pair[] q) {
		
		int count = 0;
		int num = blank + list.size() - m;
		
		int[][] curMap = new int[n][n];
			
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(map[i][j] == 2) {
					curMap[i][j] = 0;
				}else {
					curMap[i][j] = map[i][j];
				}
			}
		}
		
		Queue<Pair> queue = new LinkedList<Pair>();

		// 바이러스 1 표시
		for(Pair p: q) {
			curMap[p.x][p.y] = 1;
			queue.offer(p);
		}
		
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				Pair cur = queue.poll();
				
				for(int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					
					// 범위 벗어남
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}
					
					if(curMap[nx][ny] == 0) {
						curMap[nx][ny] = 1;
						num--;
						queue.offer(new Pair(nx,ny));
					}
				}
			}
			
			count++;
		}
		
		// 다 감염됐으면
		if(num == 0) {
			min = Math.min(min, count - 1);
		}
		
//		System.out.println(min);
	}
	
	// 바이러스 조합 만들기
	static void combi(int index, int cnt, Pair[] q) {		
		if(m == cnt) {
//			for(Pair p : q) {
//				System.out.print(p.x + "," + p.y + "/");
//			}
//			System.out.println();
			bfs(q);
			return;
		}
		
		for(int i = index; i < list.size(); i++) {
			q[cnt] = list.get(i);
			combi(i + 1, cnt + 1, q);
		}
	}
}





