import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// [백준] 1941. 소문난 칠공주 (Java)
public class Main {

    static char[] map;
    static int[] combi;
    static int[] dx = {-5, -1, 1, 5};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[25];
        combi = new int[7];

        for(int i = 0; i < 5; i++){
            String tmp = br.readLine();
            for(int j = 0; j < 5; j++){
                map[i * 5 + j] = tmp.charAt(j);
            }
        }

        combination(0, 0);
        System.out.println(result);
    }

    static void combination(int count, int start){
        if(count == 7){
            bfs();
            return;
        }

        for(int i = start; i < 25; i++){
            combi[count] = i;
            combination(count + 1, i + 1);
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];
        int count = 1;
        int yCount = 0;

        queue.offer(combi[0]);
        visited[0] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll(); // 현재 조합 인덱스

            if(map[cur] == 'Y') {
                yCount++;
            }

            if(yCount >= 4){
                break;
            }

            for(int i = 0; i < 4; i++) {
                for (int j = 1; j < 7; j++) {

                    // 이미 방문한 조합 인덱스면
                    if(visited[j]){
                        continue;
                    }

                    if(cur % 5 == 0 && i == 1){
                        continue;
                    }

                    if((cur + 1) % 5 == 0 && i == 2){
                        continue;
                    }

                    // 조합 인덱스 상하좌우 탐색
                    int nx = cur + dx[i];

                    // 조합 인덱스 범위 초과
                    if(nx < 0 || nx >= 25){
                        continue;
                    }

                    if(combi[j] != nx){
                        continue;
                    }

                    count++;
                    visited[j] = true;
                    queue.offer(combi[j]);
                }
            }
        }

        if(count == 7 && yCount < 4){
            result++;
        }
    }
}
