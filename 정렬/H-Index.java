import java.util.*;

// [프로그래머스] H-Index (Java)
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        Arrays.sort(citations);

        for(int i = 0; i < size; i++){
            int sum = size - i; // 현재 논문 인용 회수 이상 인용된 논문 개수
            
            if(sum <= citations[i]){
                answer = sum;
                break;
            }
        }
        return answer;
    }
}