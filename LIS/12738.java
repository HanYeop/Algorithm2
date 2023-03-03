import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 12738. 가장 긴 증가하는 부분 수열 3 (Java)
public class Main {

    static int n;
    static int[] arr;
    static int[] lis;
    static int length = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        for(int i = 1; i < n; i++){
            int key = arr[i];

            if(lis[length - 1] < key){
                lis[length] = key;
                length++;
            }
            else{
                int start = 0;
                int end = length;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if(lis[mid] < key){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }

                lis[start] = key;
            }
        }

        System.out.println(length);
    }
}
