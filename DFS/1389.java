import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [백준] 1389. 케빈 베이컨의 6단계 법칙 (Java)
public class Main {

    static int n; // 유저의 수
    static int m; // 친구 관계의 수
    static ArrayList<Integer>[] list; // 친구 연결 리스트
    static boolean[] visited; // 방문 여부
    static int[] result; // 각각의 케빈 수
    static int answerValue = Integer.MAX_VALUE;
    static int answerIndex;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            list[p1].add(p2);
            list[p2].add(p1);
        }

        for(int i = 1; i < n + 1; i++){
            int number = 0;

            for(int j = 1; j < n + 1; j++){
                min = Integer.MAX_VALUE;

                if(i == j) {
                    continue;
                }

                visited[i] = true;
                find(i, i, j, 0);
                visited[i] = false;

                number += min;
            }

            result[i] = number;
        }

        for(int i = 1; i < n + 1; i++){
            if(answerValue > result[i]){
                answerValue = result[i];
                answerIndex = i;
            }
        }

        System.out.println(answerIndex);
    }

    static void find(int start, int user, int target, int count){
        // 친구 관계 성립
        if(user == target){
            min = Math.min(min, count);
            return;
        }

        for(int next: list[user]){
            if(visited[next]){
                continue;
            }

            visited[next] = true;
            find(start, next, target, count + 1);
            visited[next] = false;
        }
    }
}
