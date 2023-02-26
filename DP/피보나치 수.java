// [프로그래머스] 피보나치 수 (Java)
class Solution {
    
    static int[] fibo;
        
    public int solution(int n) {
        int answer = 0;
        fibo = new int[n + 1];
        answer = solve(n);
        
        return answer;
    }
    
    static int solve(int i){
        if(fibo[i] != 0) return fibo[i];
        if(i == 0) return fibo[i] = 0;
        if(i == 1 || i == 2) return fibo[i] = 1;
        return fibo[i] = (solve(i - 2) + solve(i - 1)) % 1234567;
    }
}
