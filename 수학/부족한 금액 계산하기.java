// [프로그래머스] 부족한 금액 계산하기 (Java)
class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long multi = 0;
        
        for(int i = 1; i <= count; i++){
            multi += i;
        }
        
        long result = price * multi;
        
        if(money - result >= 0){
            answer = 0;
        }else{
            answer = Math.abs(money - result);
        }
    
        return answer;
    }
}
