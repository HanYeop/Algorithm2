import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1032. 명령 프롬프트 (Java)
public class Main {

    static int n; // 파일 이름 개수
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solve();
    }

    static void solve(){
        StringBuilder sb = new StringBuilder();
        int size = arr[0].length();

        for(int i = 0; i < size; i++){
            char tmp = arr[0].charAt(i);

            for(int j = 1; j < n; j++){
                // 같지 않은 문자가 존재
                if(tmp != arr[j].charAt(i)){
                    tmp = '?';
                    break;
                }
            }

            sb.append(tmp);
        }

        System.out.println(sb);
    }
}
