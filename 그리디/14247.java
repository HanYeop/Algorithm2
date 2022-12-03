import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [백준] 14247. 나무 자르기 (Java)
class Point implements Comparable<Point>{
    int index, value;

    Point(int index, int sort){
        this.index = index;
        this.value = sort;
    }

    @Override
    public int compareTo(Point o) {
        return this.value - o.value;
    }
}
public class Test {

    static int n; // 나무의 개수
    static int[] hi; // 첫날 나무의 길이
    static Point[] ai; // 나무들이 자라는 길이
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        hi = new int[n];
        ai = new Point[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            hi[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(st.nextToken());
            ai[i] = new Point(i, value);
        }

        solve();
        System.out.println(result);
    }

    static void solve(){
        Arrays.sort(ai);

        for(int i = 0; i < n; i++){
            result += hi[ai[i].index] + (ai[i].value * i);
        }
    }
}
