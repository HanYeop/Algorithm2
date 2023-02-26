import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 2468. 안전 영역 (Java)
public class Main {

    static int n;
    static int maxHeight = Integer.MIN_VALUE; // 최대 높이
    static int maxSpace = 1; // 안전영역 최대 개수
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight,map[i][j]);
            }
        }

        for(int i = 0; i < maxHeight; i++) {
            visited = new boolean[n][n];
            solve(i);
        }

        System.out.println(maxSpace);
    }

    static void solve(int rain){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] <= rain){
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i,j);
                    count++;
                }
            }
        }

        maxSpace = Math.max(maxSpace, count);
    }

    static void dfs(int x, int y){

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                continue;
            }

            if(visited[nx][ny]){
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx,ny);
        }
    }
}
