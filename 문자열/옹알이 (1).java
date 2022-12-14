import java.util.*;

// [프로그래머스] 옹알이 (1) (Java)
class Solution {
    
    static HashMap<String, Integer> map;
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        map = new HashMap<>();
        setting();
        
        for(int i = 0; i < babbling.length; i++){
            boolean sp = speak(babbling[i]);
            
            if(sp){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void setting(){
        map.put("aya",3);
        map.put("ye",2);
        map.put("woo",3);
        map.put("ma",2);
    }
    
    static boolean speak(String str){
        int len = str.length();
        
        // 길이가 10을 넘어가거나, 1이면 발음 불가
        if(len > 10 || len <= 1){
            return false;
        }
        
        // 4가지 단어로 발음 할 수 있는지 확인
        for(String s: map.keySet()){
            
            // 발음할 수 있는 단어면 그 길이만큼 뺌
            if(str.contains(s)){
                len -= s.length();
            }
            
            // 길이가 0이면 모든 단어 발음 가능
            if(len == 0){
                return true;
            }
        }
        
        return false;
    }
}
