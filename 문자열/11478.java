import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 11478. 서로 다른 부분 문자열의 개수 (Java)
public class Main {
	
	static String s;
	static String[] sp;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		sp = s.split("");
		
		set = new HashSet<>();
		
		for(int i = 0; i < sp.length; i++) {
			solve(sp[i], i);
		}
		
		System.out.println(set.size());
	}
	
	static void solve(String s, int index) {
		set.add(s);
		
		if(index + 1 < sp.length) {
			String tmp = s + sp[index + 1];
			solve(tmp, index + 1);
		}
	}
}
