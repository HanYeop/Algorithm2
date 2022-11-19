import java.util.*;

// [프로그래머스] 구명보트 (Java)
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int size = people.length;
        int end = size - 1;

        Arrays.sort(people);
        
        for(int i = 0; i < size; i++){
            
            // 이미 탑승
            if(people[i] == 0){
                continue;
            }
            
            for(int j = end; j >= 0; j--){
                // 두명 탑승 가능
                if(people[i] + people[j] <= limit){
                    people[j] = 0;
                    end = j - 1;
                    break;
                }
            }
            
            // 한명 탑승시킴
            people[i] = 0;
                        
            answer++;
        }

        return answer;
    }
}
