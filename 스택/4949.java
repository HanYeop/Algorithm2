package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// [백준] 4949. 균형잡힌 세상 (Java)
public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String str = br.readLine();
			
			// 입력의 종료조건
			if(str.equals(".")) {
				break;
			}
			
			if(solve(str)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
	
	static boolean solve(String str) {
		
		Stack<Character> stack = new Stack<Character>();
				
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			
			// 괄호 스택 추가
			if(cur == '(' || cur == '[') {
				stack.add(cur);
				continue;
			}
			
			// 닫는 괄호 아닌 문자 탐색 X
			if(cur != ')' && cur != ']') {
				continue;
			}
			
			// 닫는 괄호인데 스택이 비었으면 짝이 안맞음
			if(stack.isEmpty()) {
				return false;
			}
			
			// )와 ( 짝 비교
			if(cur == ')' && stack.peek() != '(') {
				return false;
			}
			
			// ]와 [ 짝 비교
			if(cur == ']' && stack.peek() != '[') {
				return false;
			}
			
			// 다 통과했으면 짝이 맞는 것이므로 pop
			stack.pop();
		}
		
		if(!stack.isEmpty()) return false;
		return true;
	}
}
