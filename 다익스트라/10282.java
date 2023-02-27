import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 10282. 해킹 (Java)
class Node implements Comparable<Node>{
    int des, second;

    Node(int des, int second){
        this.des = des;
        this.second = second;
    }

    @Override
    public int compareTo(Node o) {
        return this.second - o.second;
    }
}

public class Main {

    static int t; // 테스트 케이스 개수
    static int n; // 컴퓨터 개수
    static int d; // 의존성 개수
    static int c; // 해킹당한 컴퓨터의 번호
    static ArrayList<Node>[] list; // 의존성 리스트
    static int[] dist;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            sb = new StringBuilder();

            for(int i = 0; i < n + 1; i++){
                list[i] = new ArrayList<>();
            }
            Arrays.fill(dist, Integer.MAX_VALUE);

            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());

                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                list[c2].add(new Node(c1, second));
            }

            solve(c);

            int computer = 0;
            int sumTime = 0;

            for(int i: dist){
                if(i == Integer.MAX_VALUE){
                    continue;
                }
                sumTime = Math.max(sumTime, i);
                computer++;
            }

            sb.append(computer).append(" ").append(sumTime);
            System.out.println(sb);
        }
    }

    static void solve(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[index] = 0;
        pq.offer(new Node(index, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int des = cur.des;
            int second = cur.second;

            for (Node next : list[des]) {
                int value = second + next.second;

                if (dist[next.des] > value) {
                    dist[next.des] = value;
                    pq.offer(new Node(next.des, value));
                }
            }
        }
    }
}
