import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 10816. 숫자 카드 (Java)
public class Main {

    static int n;
    static int m;
    static int[] card;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(find(target)).append(" ");
        }

        System.out.println(sb);
    }

    // 이분 탐색
    static int find(int x){
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi){
            int mid = (lo + hi) / 2;
            int value = card[mid];

            if(x == value){
                return 1;
            }

            else if(value < x){
                lo = mid + 1;
            }

            else{
                hi = mid - 1;
            }
        }

        return 0;
    }
}
