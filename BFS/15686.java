import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 15686. 치킨 배달 (Java)
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int m;
    static int[][] map; // 0 = 빈 칸, 1 = 집, 2 = 치킨집
    static boolean[][] visited; // 방문 여부
    static int house; // 집 개수
    static ArrayList<Point> chicken; // 치킨집 위치
    static Point[] combiArr; // 만든 조합
    static int min = Integer.MAX_VALUE; // 치킨 거리 최솟값

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        chicken = new ArrayList<>();
        combiArr = new Point[m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {

                int cur = Integer.parseInt(st.nextToken());
                // 치킨집 위치 저장
                if (cur == 2) {
                    chicken.add(new Point(i, j));
                }
                // 집 개수 세기
                else if (cur == 1) {
                    house++;
                }
                map[i][j] = cur;
            }
        }

        combi(-1, 0);
        System.out.println(min);
    }

    static void combi(int index, int count) {

        // 조합 만들어지면 탐색 진행
        if (count == m) {
            bfs();
            return;
        }

        for (int i = index + 1; i < chicken.size(); i++) {
            combiArr[count] = chicken.get(i);
            combi(i, count + 1);
        }
    }

    static void bfs() {
        visited = new boolean[n + 1][n + 1];
        Queue<Point> q = new LinkedList<>();
        int sum = 0; // 치킨 거리 합계
        int curHouse = house; // 방문 해야 하는 집 개수

        // 현재 치킨집 위치 다 넣음
        for (Point p : combiArr) {
            q.offer(p);
        }

        // 현재 치킨 거리
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            // 레벨만큼 탐색
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    // 범위 벗어남
                    if (isNotRange(nx, ny)) {
                        continue;
                    }

                    // 이미 방문
                    if (visited[nx][ny]) {
                        continue;
                    }

                    // 집 방문
                    if (map[nx][ny] == 1) {
                        sum += level;
                        curHouse--;
                    }

                    // 모든 집 방문했으면 더이상 탐색 X
                    if (curHouse == 0) {
                        min = Math.min(min, sum);
                        return;
                    }

                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }

            level++;
        }

        min = Math.min(min, sum);
    }

    static boolean isNotRange(int x, int y) {
        if (x < 1 || y < 1 || x > n || y > n) {
            return true;
        } else {
            return false;
        }
    }
}
