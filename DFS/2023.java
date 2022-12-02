import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 2023. 신기한 소수 (Java)
public class Main {

    static int n; // 자리수
    static int size = 1;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            size *= 10;
        }

        sb = new StringBuilder();

        solve(new StringBuilder().append(2));
        solve(new StringBuilder().append(3));
        solve(new StringBuilder().append(5));
        solve(new StringBuilder().append(7));

        System.out.println(sb);
    }

    static void solve(StringBuilder tmp) {

        if (tmp.length() == n) {
            sb.append(tmp).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {

            // 2나 5로 끝나는 2자리 이상의 수는 소수가 아님
            if (i % 2 == 0 || i % 5 == 0) {
                continue;
            }
            tmp.append(i);

            // 소수가 아니면
            if (!findDec(Integer.parseInt(tmp.toString()))) {
                tmp.deleteCharAt(tmp.length() - 1);
                continue;
            }

            solve(tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    // 소수 찾기 (true = 소수)
    static boolean findDec(int num) {
        for(int i = 3; i < num; i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
