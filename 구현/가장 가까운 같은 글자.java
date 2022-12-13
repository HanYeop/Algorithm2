import java.util.*;

// [프로그래머스] 가장 가까운 같은 글자 (Java)
class Solution {
    
    // 최근 인덱스 저장할 해시맵
    static HashMap<Character, Integer> map;
    
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[s.length()];
        map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            
            // 앞에 같은 글자 있으면
            if(map.getOrDefault(cur, -1) != -1){
                answer[i] = i - map.getOrDefault(cur, -1);
            }else{
                answer[i] = map.getOrDefault(cur, -1);
            }
            map.put(cur, i);
        }
        
        return answer;
    }
}
