import java.util.*;

// [프로그래머스] 짝지어 제거하기 (Java)
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            
            if(stack.isEmpty()){
                stack.add(cur);
            }else if(stack.peek() == cur){
                stack.pop();
            }else{
                stack.add(cur);
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        
        return answer;
    }
}
