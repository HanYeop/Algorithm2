import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 21609. 상어 중학교 (Java)
class Point{
	int x,y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int n; // 한 변의 크기
	static int m; // 색상의 개수
	static int[][] map; // 블록 정보
	
	static Boolean[][] visited; // 블록 방문 정보
	static ArrayList<Point> maxGroup; // 크기가 가장 큰 블록 그룹
	static int maxSize = Integer.MIN_VALUE; // 크기가 가장 큰 블록 그룹의 사이즈
	static int rainbowSize; // 크기가 가장 큰 블록 그룹의 무지개 블록 개수
	static int maxX; // 현재 그룹 기준점
	static int maxY; // 현재 그룹 기준점
	
	static int score; // 점수 합계
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new Boolean[n][n];
		
		if(n == 1) {
			System.out.println(0);
			return;
		}
		// 정보 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 게임 시작, 끝날 때 까지 반복
		while(true) {
			initGame();
			
			// 정보 입력
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					// 이미 방문했다면
					if(visited[i][j]) {
						continue;
					}
					
					// 무지개, 검은 블록, 공백은 시작점X
					if(map[i][j] <= 0) {
						continue;
					}
					
					findGroup(new Point(i,j));
				}
			}
			
			if(maxSize == Integer.MIN_VALUE) {
				break;
			}
			
			remove();
			gravity();
			rotate();
			gravity();
		}
		
		System.out.println(score);
	}
	
	// 삭제
	static void remove() {
		for(Point p: maxGroup) {
			map[p.x][p.y] = -2; // -2 = 제거
		}
		score += maxSize * maxSize;
	}
	
	// 회전
	static void rotate() {
		int[][] copyMap = new int[n][n];
		int base = n - 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				copyMap[i][j] = map[j][base - i];
			}
		}
		
		map = copyMap;
	}
	
	// 중력
	static void gravity() {
		for(int i = n - 1; i >= 0; i--) {
			int count = 0;
			
			for(int j = n - 1; j >= 0; j--) {
				
				if(map[j][i] == -1) {
					count = 0;
				}
				if(map[j][i] == -2) {
					count++;
				}else if(count > 0){
					map[j + count][i] = map[j][i];
					map[j][i] = -2;
				}
			}
		}
	}
	
	// 게임 시작 시 초기화 해야할 값
	static void initGame() {	
		// 방문 배열 초기화
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}

		maxX = Integer.MIN_VALUE;
		maxY = Integer.MIN_VALUE;
		maxGroup = new ArrayList<Point>(); // 크기가 가장 큰 블록 그룹
		maxSize = Integer.MIN_VALUE; // 크기가 가장 큰 블록 그룹의 사이즈
		rainbowSize = Integer.MIN_VALUE; // 크기가 가장 큰 블록 그룹의 무지개 블록 개수
	}
	
	// 그룹 찾기
	static void findGroup(Point po) {
		Queue<Point> q = new LinkedList<Point>();
		ArrayList<Point> tmp = new ArrayList<Point>(); // 한 그룹
		ArrayList<Point> rainbow = new ArrayList<Point>(); // 방문처리 한 무지개 블록 다시 돌려놓기 위함

		int color = map[po.x][po.y]; // 현재 색상
		
		// 처음 위치 방문 처리, 그룹 만들기
		visited[po.x][po.y] = true;
		q.offer(po);
		tmp.add(po);
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 범위 벗어남
				if(!isRange(nx,ny)) {
					continue;
				}
				
				// 이미 방문함
				if(visited[nx][ny]) {
					continue;
				}
				
				// 검은색 블록 탐색X
				if(map[nx][ny] == -1) {
					continue;
				}
								
				// 현재 블록과 같은 색상일 때 방문 처리, 탐색
				if(map[nx][ny] == color || map[nx][ny] == 0) {
					Point p = new Point(nx,ny);

					visited[nx][ny] = true;
					tmp.add(p);
					q.offer(p);
					
					// 무지개색 블록 같은 탐색때만 방문처리 한 탐색 종료시 다시 돌려놓음
					if(map[nx][ny] == 0) {
						rainbow.add(p);
					}
				}
			}
		}
		
		// 무지개 블록 방문처리 초기화
		for(Point p: rainbow) {
			visited[p.x][p.y] = false; 
		}
				
		// 그룹에 속한 블록은 2개 이상
		if(tmp.size() >= 2) {
			maxFind(tmp.size(), rainbow.size(), tmp, po);
		}
	}
	
	// 최대 비교
	static void maxFind(int size, int rainbow, ArrayList<Point> tmp, Point base) {
		
		// 기존 그룹이 더 큼
		if(size < maxSize) {
			return;
		}
		
		// 새로운 그룹이 더 큼, 갱신
		if(size > maxSize) {
			changeMax(size, rainbow, tmp);
			return;
		}
		
		// 다음 우선순위 비교
		if(size == maxSize) {
			
			// 기존 그룹이 더 큼
			if(rainbow < rainbowSize) {
				return;
			}
			
			// 새로운 그룹이 더 큼, 갱신
			if(rainbow > rainbowSize) {
				changeMax(size, rainbow, tmp);
				return;
			}
			
			// 다음 우선순위 비교
			if(rainbow == rainbowSize) {
				
				int curX = base.x;
						
				// 기존 그룹이 더 큼
				if(curX < maxX) {
					return;
				}
				
				// 새로운 그룹이 더 큼, 갱신
				if(curX > maxX) {
					changeMax(size, rainbow, tmp);
					return;
				}
				
				if(curX == maxX) {
					int curY = base.y;
							
					// 기존 그룹이 더 큼
					if(curY < maxY) {
						return;
					}
					
					// 새로운 그룹이 더 큼, 갱신
					if(curY > maxY) {
						changeMax(size, rainbow, tmp);
						return;
					}
				}
			}
		}
	}
	
	// 최대 변경
	static void changeMax(int size, int rainbow, ArrayList<Point> tmp) {
		maxSize = size;
		rainbowSize = rainbow;
		maxGroup = tmp;
	}
	
	// 범위 체크
	static Boolean isRange(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= n) {
			return false;
		}else {
			return true;
		}
	}
}
