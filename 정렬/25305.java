import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// [백준] 25305. 커트라인 (Java)
public class Main {

    static int n; // 응시자 수
    static int k; // 상 받는 사람 수
    static Integer[] score; // 학생의 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        score = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score, Collections.reverseOrder());

        System.out.println(score[k - 1]);
    }
}
