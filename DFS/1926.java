import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1926. 그림 (Java)
public class Main {

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int result = 0;
    static int count = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j]){
                    continue;
                }

                if(map[i][j] != 1){
                    continue;
                }

                count = 1;
                result++;
                visited[i][j] = true;
                dfs(i,j);
            }
        }

        System.out.println(result);
        System.out.println(max);
    }

    static void dfs(int x, int y){

        max = Math.max(max, count);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                continue;
            }

            if(visited[nx][ny]){
                continue;
            }

            if(map[nx][ny] == 0){
                continue;
            }

            visited[nx][ny] = true;
            count++;
            dfs(nx, ny);
        }
    }
}
