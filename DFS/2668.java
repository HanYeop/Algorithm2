import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2668. 숫자고르기 (Java)
public class Main {

    static int n;
    static int[] one;
    static int[] two;
    static PriorityQueue<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        one = new int[n];
        two = new int[n];
        result = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            one[i] = i + 1;
            two[i] = Integer.parseInt(br.readLine());
        }

        solve();

        System.out.println(result.size());
        while (!result.isEmpty()){
            System.out.println(result.poll());
        }
    }

    static void solve(){
        for(int i = 0; i < n; i++){
            int n1 = one[i];
            int n2 = two[i];

            // 이미 뽑은 수
            if(n1 == 0){
                continue;
            }

            // 위아래가 같은 수는 결과에 추가
            if(n1 == n2){
                result.add(n1);
                continue;
            }

            // 서로 반대되는 수 뽑음
            for(int j = i + 1; j < n; j++){
                if(one[j] == n2 && two[j] == n1){
                    add(n1, n2, j);
                    break;
                }
            }
        }
    }

    static void add(int n1, int n2, int index){
        result.add(n1);
        result.add(n2);
        one[index] = 0;
    }
}
