import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 10798. 세로읽기 (Java)
public class Main {

    static String[] strings;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strings = new String[5];
        sb = new StringBuilder();

        for(int i = 0; i < 5; i++){
            strings[i] = br.readLine();
        }

        solve();

        System.out.println(sb);
    }

    static void solve(){

        int count = 0;
        int end = 5;

        while (end > 0){
            end = 5;
            for(int i = 0; i < 5; i++){
                if(count >= strings[i].length()){
                    end--;
                    continue;
                }
                sb.append(strings[i].charAt(count));
            }
            count++;
        }
    }
}
