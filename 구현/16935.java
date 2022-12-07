import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 16935. 배열 돌리기 3 (Java)
public class Main2 {

    static int n;
    static int m;
    static int r;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        // 초기 배열 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int type = Integer.parseInt(st.nextToken());

            switch (type) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }

        // 결과 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void one() {
        int[][] copyMap = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyMap[i][j] = arr[n - 1 - i][j];
            }
        }
        arr = copyMap;
    }

    static void two() {
        int[][] copyMap = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyMap[i][j] = arr[i][m - 1 - j];
            }
        }
        arr = copyMap;
    }

    static void three(){
        // 가로 세로 길이 스왑
        swap();
        int[][] copyMap = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyMap[i][j] = arr[m - j - 1][i];
            }
        }
        arr = copyMap;
    }

    static void four(){
        // 가로 세로 길이 스왑
        swap();
        int[][] copyMap = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyMap[i][j] = arr[j][n - 1 - i];
            }
        }
        arr = copyMap;
    }

    static void five(){
        int[][] copyMap = new int[n][m];

        int nSize = n / 2;
        int mSize = m / 2;

        // 4 -> 1
        for(int i = 0; i < nSize; i++){
            for(int j = 0; j < mSize; j++){
                copyMap[i][j] = arr[i + nSize][j];
            }
        }

        // 1 -> 2
        for(int i = 0; i < nSize; i++){
            for(int j = mSize; j < m; j++){
                copyMap[i][j] = arr[i][j - mSize];
            }
        }
        // 2 -> 3
        for(int i = nSize; i < n; i++){
            for(int j = mSize; j < m; j++){
                copyMap[i][j] = arr[i - nSize][j];
            }
        }

        // 3 -> 4
        for(int i = nSize; i < n; i++){
            for(int j = 0; j < mSize; j++){
                copyMap[i][j] = arr[i][j + mSize];
            }
        }

        arr = copyMap;
    }

    static void six(){
        int[][] copyMap = new int[n][m];

        int nSize = n / 2;
        int mSize = m / 2;

        // 2 -> 1
        for(int i = 0; i < nSize; i++){
            for(int j = 0; j < mSize; j++){
                copyMap[i][j] = arr[i][j + mSize];
            }
        }

        // 3 -> 2
        for(int i = 0; i < nSize; i++){
            for(int j = mSize; j < m; j++){
                copyMap[i][j] = arr[i + nSize][j];
            }
        }
        // 4 -> 3
        for(int i = nSize; i < n; i++){
            for(int j = mSize; j < m; j++){
                copyMap[i][j] = arr[i][j - mSize];
            }
        }

        // 1 -> 4
        for(int i = nSize; i < n; i++){
            for(int j = 0; j < mSize; j++){
                copyMap[i][j] = arr[i - nSize][j];
            }
        }

        arr = copyMap;
    }

    static void swap(){
        int tmp = n;
        n = m;
        m = tmp;
    }
}
