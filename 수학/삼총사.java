// [프로그래머스] 삼총사 (Java)
class Solution {
    
    static int size;
    static int[] numbers;
    static int result = 0;
    
    public int solution(int[] number) {
        int answer = 0;
        numbers = number;
        size = number.length;
        
        combi(0, 0, 0);
        
        answer = result;
        return answer;
    }
    
    static void combi(int start, int sum, int count){
        // 세 명 모였을 때
        if(count == 3){
            // 삼총사 완성
            if(sum == 0){
                result++;
            }
            return;
        }
        
        for(int i = start; i < size; i++){
            combi(i + 1, sum + numbers[i], count + 1);
        }
    }
}
