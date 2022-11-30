import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

// [백준] 1181. 단어 정렬 (Java)
public class Main {
	
	static class Node implements Comparable<Node>{
		String st;
		int len;
		
		Node(String st, int len){
			this.st = st;
			this.len = len;
		}
		
		// 정렬 조건
		@Override
		public int compareTo(Node o) {
			if(this.len == o.len) {
				return this.st.compareTo(o.st);
			}else {
				return this.len - o.len;
			}
		}

		@Override
		public String toString() {
			return st;
		}
	}

	static int n; // 단어 개수
	static TreeSet<Node> set; // 정렬된 set
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		set = new TreeSet<Node>();

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			set.add(new Node(str, str.length()));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Node no: set) {
			sb.append(no + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
