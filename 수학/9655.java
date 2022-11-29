import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준] 9655. 돌 게임 (Java)
public class Main {
	
	static int n; // 돌 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		if(n % 4 == 1 || n % 4 == 3) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
}
