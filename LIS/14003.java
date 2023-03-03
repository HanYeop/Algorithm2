import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 14003. 가장 긴 증가하는 부분 수열 5 (Java)
public class Main {

    static int n;
    static int[] arr;
    static int[] lis;
    static int[] index;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];
        index = new int[n];
        sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0]; // LIS 초기값
        int lengthOfLis = 1; // LIS 길이
        index[0] = lengthOfLis; // 인덱스 초기값

        // 가장 긴 수열 구하기
        for(int i = 1; i < n; i++){
            int key = arr[i];

            // key 가 LIS 마지막 값보다 클 경우 추가
            if(lis[lengthOfLis - 1] < key){
                lis[lengthOfLis] = key;
                lengthOfLis++;

                // 몇번 위치에 삽입되는지
                index[i] = lengthOfLis;
            }

            // Lower Bound
            else{
                int lo = 0;
                int hi = lengthOfLis;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if(lis[mid] < key) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid;
                    }

                }

                // 몇번 위치에 삽입되는지
                index[i] = lo + 1;
                lis[lo] = key;
            }
        }

        sb.append(lengthOfLis).append("\n");
        result = new int[lengthOfLis];

        // 역순 탐색하면서 수열 길이 큰거 만나는 순서로 넣기
        for (int i = n - 1; i >= 0; i--){
            if(index[i] == lengthOfLis){
                result[--lengthOfLis] = arr[i];
            }
        }

//        System.out.println(Arrays.toString(index));

        for(int i: result){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
