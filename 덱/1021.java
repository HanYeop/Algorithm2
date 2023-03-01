import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 1021. 회전하는 큐 (Java)
public class Main {

    static int n;
    static int m;
    static LinkedList<Integer> deque;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        deque = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            solve(Integer.parseInt(st.nextToken()));
        }

        System.out.println(answer);
    }

    static void solve(int target){
        int index = deque.indexOf(target);
        int size = deque.size();
        int half;

        if(size % 2 == 0){
            half = size / 2 - 1;
        }else{
            half = size / 2;
        }

        if(index <= half){
            for(int i = 0; i < index; i++) {
                int tmp = deque.pollFirst();
                deque.offerLast(tmp);
                answer++;
            }
        }else{
            for(int i = 0; i < size - index; i++) {
                int tmp = deque.pollLast();
                deque.offerFirst(tmp);
                answer++;
            }
        }

        deque.pollFirst();
    }
}