import java.util.*;

// [프로그래머스] 푸드 파이트 대회 (Java)
class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder tmp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i] / 2 ; j++){
                tmp.append(i);
            }
        }
        
        result.append(tmp);
        tmp.reverse();
        result.append(0);
        result.append(tmp);
        
        answer = result.toString();
        return answer;
    }
}
