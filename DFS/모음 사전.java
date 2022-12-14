import java.util.*;

// [프로그래머스] 모음 사전 (Java)
class Solution {
    
    static int index;
    static int max = 5;
    
    static HashMap<String, Integer> map;
    
    public int solution(String word) {
        int answer = 0;
        
        map = new HashMap<>();
    
        solve("", 0);
        
        answer = map.get(word);
        
        return answer;
    }
    
    static void solve(String str, int length){
        map.put(str, index++);
        
        if(length == max){
            return;
        }
        
        solve(str + "A", length + 1);
        solve(str + "E", length + 1);
        solve(str + "I", length + 1);
        solve(str + "O", length + 1);
        solve(str + "U", length + 1);
    }
    
}
