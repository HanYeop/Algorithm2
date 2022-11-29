import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [백준] 2475. 검증수 (Java)
public class Main {
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			sum += num * num % 10;
		}
		
		System.out.println(sum % 10);
	}
}
