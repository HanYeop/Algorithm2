import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2668. 숫자고르기 (Java)
public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static TreeSet<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        result = new TreeSet<>();
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // DFS
        for(int i = 1; i <= n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            solve(i, arr[i], list);
        }

        // 결과 출력
        System.out.println(result.size());
        for(int i : result){
            System.out.println(i);
        }
    }

    static void solve(int start, int next, ArrayList<Integer> list){

        // 사이클 발생 시 원소 전부 결과에 추가
        if(start == next){
            for(int i : list){
                result.add(i);
            }
            return;
        }

        // 의미없는 사이클 발생 시 종료
        if(list.size() >= n){
            return;
        }

        list.add(next);
        solve(start, arr[next], list);
        list.remove(list.size() - 1);
    }
}
