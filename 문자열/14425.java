import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 14425. 문자열 집합 (Java)
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<String> mainList = new ArrayList<>();
		ArrayList<String> strList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			mainList.add(br.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			strList.add(br.readLine());
		}
		
		strList.retainAll(mainList);
		
		System.out.println(strList.size());
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [백준] 14425. 문자열 집합 (Java) - 풀이2
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			if(set.contains(br.readLine())) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}





