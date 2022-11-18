import java.util.*;

// [프로그래머스] 같은 문자는 싫어 (Java)
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < arr.length; i++){
            if(!stack.isEmpty()){
                if(arr[i] == stack.peek()){
                    continue;
                }
            }
            
            stack.push(arr[i]);
        }
        
        ArrayList<Integer> list = new ArrayList();
        
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        
        Collections.reverse(list);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}