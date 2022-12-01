import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// [백준] 17413. 단어 뒤집기 2 (Java)
public class Main {
	
	static String s;
	static StringBuilder sb;
	static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		s = br.readLine();
		sb = new StringBuilder();
		
		solve();
		
		System.out.println(sb);
	}
	
	static void solve() {
		stack = new Stack<Character>();
		boolean flag = false; // 현재 괄호에 포함되는 상태인지
		
		for(int i = 0; i <s.length(); i++) {
			char cur = s.charAt(i);
			
			// 괄호 상태 종료, 괄호 추가
			if(cur == '>') {
				flag = false;
				sb.append(cur);
			}
			
			// 괄호 상태 시작, 괄호 추가, 괄호 시작하면 스택 리턴
			else if(cur == '<') {
				flag = true;
				stackClear();
				sb.append(cur);
			}
			
			else if(flag) {
				sb.append(cur);
			}
			
			// 공백 만나면 스택에 포함되어 있는 문자들 전부 리턴
			else if(cur == ' ') {
				stackClear();
				sb.append(cur);
			}
			
			else {
				stack.add(cur);
			}
		}
		
		stackClear();
	}
	
	// 스택 비워서 거꾸로 출력
	static void stackClear() {
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
