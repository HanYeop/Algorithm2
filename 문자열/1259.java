import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1259. 팰린드롬수 (Java)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String n = br.readLine();

            if(n.equals("0")){
                return;
            }

            System.out.println(solve(n));
        }
    }

    static String solve(String n){
        int size = n.length();

        for(int i = 0; i < (size / 2); i++){
            // 좌우 대칭 확인
            if(n.charAt(i) != n.charAt(size - 1 - i)){
                return "no";
            }
        }

        return "yes";
    }
}
