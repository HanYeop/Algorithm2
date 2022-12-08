import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 1919. 애너그램 만들기 (Java)
public class Main {

    static int[] countArr1;
    static int[] countArr2;
    static String str1;
    static String str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        countArr1 = new int[26];
        countArr2 = new int[26];
        str1 = br.readLine();
        str2 = br.readLine();

        counting();
        result();
    }

    static void counting() {
        for(int i = 0; i < str1.length(); i++){
            char cur = str1.charAt(i);
            countArr1[cur - 'a']++;
        }

        for(int i = 0; i < str2.length(); i++){
            char cur = str2.charAt(i);
            countArr2[cur - 'a']++;
        }
    }

    static void result(){
        int result = 0;

        for(int i = 0; i < 26; i++){
            int count = Math.abs(countArr1[i] - countArr2[i]);
            result += count;
        }

        System.out.println(result);
    }
}
