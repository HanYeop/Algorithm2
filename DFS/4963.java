import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 4963. 섬의 개수 (Java)
public class Main {
	
	static int w; // 지도의 너비
	static int h; // 지도의 높이
	static int count;
	static int[][] map;
	static StringBuilder sb;
	
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[h][w];
			
			// 종료조건
			if(w == 0 && h == 0) {
				break;
			}
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < w; j++) {
					map[i][j] =	Integer.parseInt(st.nextToken()); 
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						solve(i,j);
						count++;
					}
				}
			}
			
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void solve(int x, int y) {	
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 벗어남
			if(!isRange(nx,ny)) {
				continue;
			}
			
			// 이미 방문했거나 바다
			if(map[nx][ny] == 0) {
				continue;
			}
			
			map[nx][ny] = 0;
			solve(nx,ny);
		}
	}
	
	static boolean isRange(int x, int y) {
		if(x < 0 || y < 0 || x >= h || y >= w) {
			return false;
		}else {
			return true;
		}
	}
}
