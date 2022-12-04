import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// [백준] 10845. 큐 (Java)
public class Main {

    static int n; // 명령의 수
    static LinkedList<Integer> q;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            switch (type) {
                case "push" : {
                    push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop" : {
                    pop();
                    break;
                }
                case "size" : {
                    size();
                    break;
                }
                case "empty" : {
                    empty();
                    break;
                }
                case "front" : {
                    front();
                    break;
                }
                case "back" : {
                    back();
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static void push(int n){
        q.offer(n);
    }

    static void pop(){
        if(q.isEmpty()){
            sb.append(-1).append("\n");
        }else{
            sb.append(q.poll()).append("\n");
        }
    }

    static void size(){
        sb.append(q.size()).append("\n");
    }

    static void empty(){
        if(q.isEmpty()){
            sb.append(1).append("\n");
        }else{
            sb.append(0).append("\n");
        }
    }

    static void front(){
        if(q.isEmpty()){
            sb.append(-1).append("\n");
        }else{
            sb.append(q.peek()).append("\n");
        }
    }

    static void back(){
        if(q.isEmpty()){
            sb.append(-1).append("\n");
        }else{
            sb.append(q.peekLast()).append("\n");
        }
    }
}
