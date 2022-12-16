import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1543. 문서 검색 (Java)
public class Main4 {

    static String doc;
    static String search;
    static int size;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        doc = br.readLine();
        search = br.readLine();
        size = search.length();

        solve();
        System.out.println(result);
    }

    static void solve(){
        // 시작점 전부 비교
        for(int i = 0; i <= doc.length() - size; i++){
            int index = 0;

            for(int j = i; j < i + size; j++){
                char cur = doc.charAt(j);
                char target = search.charAt(index);

                // 비교 도중 같지 않다고 판별되면 break
                if(cur != target){
                    break;
                }
                index++;
            }

            // 검색 완료
            if(index == size){
                i += index - 1; // 건너뛰기
                result++;
            }
        }
    }
}
