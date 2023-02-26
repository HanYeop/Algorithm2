// [프로그래머스] 크기가 작은 부분문자열 (Java)
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pInt = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - p.length(); i++){
            String str = t.substring(i, i + p.length());
            
            long target = Long.parseLong(str);
            
            if(pInt >= target){
                answer++;
            }
        }
        
        return answer;
    }
}
