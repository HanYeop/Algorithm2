import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 11404. 플로이드 (Java)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		
		int[][] city = new int[n + 1][n + 1];
		
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= n; j++) {
//				city[i][j] = Integer.MAX_VALUE;
//			}
//		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			if(value < city[start][end] || city[start][end] == 0) {
				city[start][end] = value;
			}
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(i == j) continue;
					
					if(city[i][k] > 0 && city[k][j] > 0){
						if((city[i][k] + city[k][j] < city[i][j]) ||
								city[i][j] == 0) {
//							System.out.println("i: " + i +" j: " + j + " 1: " + city[i][k]+ " 2: " + city[k][j] + " k: " + k);
							city[i][j] = city[i][k] + city[k][j];
						}
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}
}