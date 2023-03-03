import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 12015. 가장 긴 증가하는 부분 수열 2 (Java)
public class Main {

    static int n;
    static int[] arr;
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0]; // LIS 초기값
        int lengthOfLis = 1; // LIS 길이

        // 가장 긴 수열 길이 구하기
        for(int i = 1; i < n; i++){
            int key = arr[i];

            // key 가 LIS 마지막 값보다 클 경우 추가
            if(lis[lengthOfLis - 1] < key){
                lis[lengthOfLis] = key;
                lengthOfLis++;
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

                lis[lo] = key;
            }
        }
        System.out.println(lengthOfLis);
    }
}
