// [프로그래머스] 위장 (Java)
import java.util.*;

class Solution {
    static Map<String, Integer> map;
    
    public int solution(String[][] clothes) {
        int answer = 0;
        int sum = 1;
        map = new HashMap();
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);    
        }
        
        for(int value: map.values()){
            sum *= value + 1;
        }
        
        answer = sum - 1;
        return answer;
    }
}
