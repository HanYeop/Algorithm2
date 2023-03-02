import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1952. 달팽이2 (Java)
public class Main {

    static int m,n;
    static int count;
    static boolean[][] visited;

    // 우하좌상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];

        solve();

        System.out.println(count);
    }

    static void solve(){
        int num = m * n - 1;
        int curDir = 0;
        int curX = 0;
        int curY = 0;
        visited[curX][curY] = true;

        while (num != 0){
            int nx = curX + dx[curDir];
            int ny = curY + dy[curDir];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) {
                curDir = (curDir + 1) % 4;
                count++;
                continue;
            }

            visited[nx][ny] = true;
            curX = nx;
            curY = ny;

            num--;
        }
    }
}
