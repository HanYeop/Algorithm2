import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 2563. 색종이 (Java)
public class Main {

    static int n; // 색종이 수
    static int[][] canvas;
    static int size = 100 + 1;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        canvas = new int[size][size];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());

            for (int j = left; j < left + 10; j++) {
                for (int q = bottom; q < bottom + 10; q++) {
                    canvas[j][q] = 1;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result += canvas[i][j];
            }
        }

        System.out.println(result);
    }
}
