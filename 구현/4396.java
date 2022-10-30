import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// [백준] 4396. 지뢰찾기 (Java)
class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	// 8방향
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] map = new String[n][n]; // 게임판
		String[][] game = new String[n][n]; // 실제 게임 진행결과
		ArrayList<Pair> list = new ArrayList<>(); // 지뢰 위치
		boolean check = false; // 지뢰 클릭 여부
		
		// 게임판 만들기
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			String[] tmpList = tmp.split("");
			
			for(int j = 0; j < n; j++) {
				// 지뢰 위치 기록
				if(tmpList[j].equals("*")) {
					list.add(new Pair(i,j));
				}
				map[i][j] = tmpList[j];
			}
		}
		
		// 결과 만들기
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			String[] tmpList = tmp.split("");
			
			for(int j = 0; j < n; j++) {
				// 클릭한 곳
				if(tmpList[j].equals("x")) {
					// 지뢰를 클릭했다면
					if(map[i][j].equals("*")) {
						check = true;
					}else {
						int count = 0; // 주변 지뢰 개수
						// 8방향 탐색
						for(int k = 0; k < 8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							
							// 범위를 벗어나면
							if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
								continue;
							}
							
							// 주변에 지뢰 있으면
							if(map[nx][ny].equals("*")) count++;
						}
						game[i][j] = String.valueOf(count);
					}
				}else {
					game[i][j] = ".";
				}
			}
		}
		
		// 모든 지뢰 표시
		if(check) {
			for(Pair p : list) {
				game[p.x][p.y] = "*";
			}
		}
		
		// 결과 출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(game[i][j]);
			}
			System.out.println();
		}
	}
}