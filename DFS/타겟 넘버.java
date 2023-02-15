// [프로그래머스] 타겟 넘버 (Java)
class Solution {
    static int len = 0;
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        len = numbers.length;
    
        solve(numbers, target, 0, 0);
        answer = result;
        return answer;
    }
    
    static void solve(int[] numbers, int target, int count, int sum){
        if(len == count){
            if(sum == target){
                result++;
            }
            return;
        }
        
        solve(numbers, target, count + 1, sum - numbers[count]);
        solve(numbers, target, count + 1, sum + numbers[count]);
    }
}
