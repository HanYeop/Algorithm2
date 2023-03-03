import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2638. 치즈 (Java)
public class Main {

    static int n,m;
    static int[][] map;
    static int[][] visited;
    static int answer;
    static int cheese;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int value = Integer.parseInt(st.nextToken());
                // 처음 치즈 개수 세기
                if(value == 1){
                    cheese++;
                }
                map[i][j] = value;
            }
        }

        while (cheese > 0) {
            visited = new int[n][m];
            answer++;

            visited[0][0] = -1;
            edge(0, 0);
            delete();
        }

        System.out.println(answer);
    }

    static void edge(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나면
            if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                continue;
            }

            // 치즈가 없고, 이미 방문한 곳
            if(visited[nx][ny] == -1){
                continue;
            }

            // 치즈 접촉
            if(map[nx][ny] == 1){
                visited[nx][ny]++;
                continue;
            }

            visited[nx][ny] = -1;
            edge(nx, ny);
        }
    }

    static void delete(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 사라지지 않는 치즈
                if(visited[i][j] < 2){
                    continue;
                }

                map[i][j] = 0;
                cheese--;
            }
        }
    }
}
