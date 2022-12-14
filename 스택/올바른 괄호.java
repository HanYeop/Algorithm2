import java.util.*;

// [프로그래머스] 올바른 괄호 (Java)
class Solution {
    
    static Stack<Character> stack; 
    
    boolean solution(String s) {
        boolean answer = true;
        
        stack = new Stack<>();

        answer = solve(s);
        
        return answer;
    }
    
    static boolean solve(String s){
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            
            if(cur == ')'){
                
                // 스택이 비어있는데 ')' 라면 성립할 수 없음
                if(stack.isEmpty()){
                    return false;
                }
                
                char top = stack.pop();
                
                // 괄호 짝 안맞으면
                if(top != '('){
                    return false;
                }
                
            }else{
                stack.add(cur);
            }
        }
        
        // 탐색 종료 후 스택에 남아있다면
        if(!stack.isEmpty()){
            return false;
        }
        
        return true;
    }
}
