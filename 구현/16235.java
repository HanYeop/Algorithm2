import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 16235. 나무 재테크 (Java)

class Tree {
    int x, y, age;

    Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}

public class Main {

    static int n; // 땅 크기
    static int m; // 초기 나무 개수
    static int k; // 지난 년도
    static Deque<Integer>[][] map; // 나무가 있는 땅 정보
    static int[][] energy; // 양분 공급 정보
    static int[][] energyMap; // 땅 양분 정보
    static Queue<Tree> deadTrees; // 죽은 트리 정보
    static int result; // 결과값

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Deque[n + 1][n + 1];
        energy = new int[n + 1][n + 1];
        energyMap = new int[n + 1][n + 1];
        deadTrees = new LinkedList<>();

        // 나무 정보 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        // 초기 양분 정보
        for (int i = 1; i <= n; i++) {
            Arrays.fill(energyMap[i], 5);
        }

        // 양분 공급 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                energy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 나무 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            map[x][y].add(age);
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fallAndWinter();
        }

        sum();
    }

    // 결과 계산
    static void sum() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result += map[i][j].size();
            }
        }
        System.out.println(result);
    }

    static void spring() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                int size = map[i][j].size();
                for(int q = 0; q < size; q++) {
                    int cur = map[i][j].poll();

                    // 먹을 수 있는 양분이 모자라면 나머지 전부 죽음
                    if (energyMap[i][j] - cur < 0) {
                        deadTrees.add(new Tree(i, j, cur));
                    }
                    // 나무 자람
                    else {
                        energyMap[i][j] -= cur;
                        map[i][j].add(cur + 1);
                    }
                }
            }
        }
    }

    static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree cur = deadTrees.poll();

            // 죽은 나무 양분 추가
            energyMap[cur.x][cur.y] += (cur.age / 2);
        }
    }

    // 가을, 겨울은 서로 영향 미치지 않음
    static void fallAndWinter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                ArrayList<Tree> list = new ArrayList<>();

                for (int age : map[i][j]) {

                    if (age % 5 != 0) {
                        continue;
                    }

                    for (int q = 0; q < 8; q++) {
                        int nx = i + dx[q];
                        int ny = j + dy[q];

                        if (isNotRange(nx, ny)) {
                            continue;
                        }

                        list.add(new Tree(nx, ny, 1));
                    }
                }

                for (Tree tree : list) {
                    map[tree.x][tree.y].addFirst(1);
                }

                energyMap[i][j] += energy[i][j];
            }
        }
    }

    static boolean isNotRange(int x, int y) {
        if (x < 1 || y < 1 || x > n || y > n) {
            return true;
        } else {
            return false;
        }
    }
}
