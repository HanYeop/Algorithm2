import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 2609. 최대공약수와 최소공배수 (Java)
public class Main {
	
	static int size = (10000 * 10000);
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		if(num1 >= num2) {
			max(num1, num2);
			min(num1, num2);
		}else {
			max(num2, num1);
			min(num2, num1);
		}

	}
	
	static void max(int n1, int n2) {
		for(int i = n1; i > 0; i--) {
			if(n1 % i == 0 && n2 % i == 0) {
				System.out.println(i);
				return;
			}
		}
	}
	
	static void min(int n1, int n2) {
		for(int i = n1; i <= size ; i++) {
			if(i % n1 == 0 && i % n2 == 0) {
				System.out.println(i);
				return;
			}
		}
	}
}
