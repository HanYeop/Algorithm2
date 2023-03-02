import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 23083. 꿀벌 승연이 (Java)
public class Main {

    static int n,m,k;
    final static int num = 1000000000 + 7;
    static int[][] map;

    static int[] oddDx = {-1, 0, 1}; // 열이 홀수일 때
    static int[] evenDx = {0, 1, 1}; // 열이 짝수일 때
    static int[] dy = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        map = new int[n + 1][m + 1];

        map[1][1] = 1;

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = -1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i % 2 == 0){
                    solve(j, i, evenDx);
                }else{
                    solve(j, i, oddDx);
                }
            }
        }
        
        System.out.println(map[n][m]);
    }

    static void solve(int x, int y, int[] dx){
        int value = map[x][y];

        if(value == -1){
            return;
        }

        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || ny <= 0 || nx > n || ny > m){
                continue;
            }

            if(map[nx][ny] == -1){
                continue;
            }

            map[nx][ny] += value;
            map[nx][ny] %= num;
        }
    }
}
