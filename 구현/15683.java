import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 15683. 감시 (Java)
class Point{
    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int blank; // 빈 칸 개수
    static int curBlank; // 탐색하며 남은 빈 칸 개수
    static boolean[][] visited; // 방문 배열
    static Point[] camera; // 카메라 위치
    static int[] combination; // 카메라 조합
    static int cameraCount; // 카메라 수
    static int min = Integer.MAX_VALUE;

    // 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        camera = new Point[8];
        combination = new int[8];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 빈 칸 개수 카운트
                if (map[i][j] == 0) {
                    blank++;
                }
                // 카메라 위치 저장
                else if(map[i][j] != 6){
                    camera[cameraCount++] = new Point(i,j);
                }
            }
        }

        combi(0, 0);
        System.out.println(min);
    }

    static void solve(){
        visited = new boolean[n][m];
        curBlank = blank;

        for(int i = 0; i < cameraCount; i++){
            int type = combination[i];
            int x = camera[i].x;
            int y = camera[i].y;

            if (type == 10){
                start(x, y, 0);
            }else if(type == 11){
                start(x, y, 1);
            }
            else if(type == 12){
                start(x, y, 2);
            }
            else if(type == 13){
                start(x, y, 3);
            }
            else if(type == 20){
                start(x, y, 0);
                start(x, y, 2);
            }
            else if(type == 21){
                start(x, y, 1);
                start(x, y, 3);
            }
            else if(type == 30){
                start(x, y, 0);
                start(x, y, 1);
            }
            else if(type == 31){
                start(x, y, 1);
                start(x, y, 2);
            }
            else if(type == 32){
                start(x, y, 2);
                start(x, y, 3);
            }
            else if(type == 33){
                start(x, y, 3);
                start(x, y, 0);
            }
            else if(type == 40){
                start(x, y, 1);
                start(x, y, 2);
                start(x, y, 3);
            }
            else if(type == 41){
                start(x, y, 2);
                start(x, y, 3);
                start(x, y, 0);
            }
            else if(type == 42){
                start(x, y, 3);
                start(x, y, 0);
                start(x, y, 1);
            }
            else if(type == 43){
                start(x, y, 0);
                start(x, y, 1);
                start(x, y, 2);
            }
            else if(type == 50){
                start(x, y, 0);
                start(x, y, 1);
                start(x, y, 2);
                start(x, y, 3);
            }
        }

        min = Math.min(min, curBlank);
    }

    static void combi(int index, int count) {
        if(count == cameraCount){
//            System.out.println(Arrays.toString(combination));
            solve();
            return;
        }

        // 현재 카메라 타입
        int type = map[camera[index].x][camera[index].y];

        if (type == 1){
            for(int i = 0; i < 4; i++){
                combination[count] = (10 + i);
                combi(index + 1, count + 1);
            }
        }else if(type == 2){
            for(int i = 0; i < 2; i++){
                combination[count] = (20 + i);
                combi(index + 1, count + 1);
            }
        }else if(type == 3){
            for(int i = 0; i < 4; i++){
                combination[count] = (30 + i);
                combi(index + 1, count + 1);
            }
        }
        else if(type == 4){
            for(int i = 0; i < 4; i++){
                combination[count] = (40 + i);
                combi(index + 1, count + 1);
            }
        }
        else if(type == 5){
            combination[count] = 50;
            combi(index + 1, count + 1);
        }
    }

    // 특정 방향으로 탐색 (상우하좌 = 1234)
    static void start(int x, int y, int dir) {
        int level = 0;
        visited[x][y] = true;

        while (true) {
            level++;
            int nx = x + (dx[dir] * level);
            int ny = y + (dy[dir] * level);

            // 범위 벗어나거나 벽 만나면 탐색 종료
            if (isNotRange(nx, ny)) {
                return;
            }

            // 이미 방문한 곳이면 건너 뜀
            if(visited[nx][ny]){
                continue;
            }

            // 다른 카메라가 있다면 건너 뜀
            if(map[nx][ny] != 0){
                continue;
            }

            curBlank--;
            visited[nx][ny] = true;
        }
    }

    static boolean isNotRange(int x, int y) {
        // 범위 벗어남
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return true;
        }
        // 벽
        else if (map[x][y] == 6) {
            return true;
        } else {
            return false;
        }
    }
}
