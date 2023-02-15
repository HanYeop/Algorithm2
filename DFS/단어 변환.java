// [프로그래머스] 단어 변환 (Java)
class Solution {
    static int visited[];
    static int wordsLen;
    static int result;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        wordsLen = words.length;
        
        visited = new int[wordsLen];
        
        for(int i = 0; i < wordsLen; i++){
            visited[i] = Integer.MAX_VALUE;
        }
        
        solve(begin, target, words, 0);
        
        answer = result;
        return answer;
    }
    
    static void solve(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            result = count;
            return;
        }
        
        for(int i = 0; i < wordsLen; i++){
            if(count + 1 >= visited[i]){
                continue;
            }  
            
            if(!transform(begin, words[i])){
                continue;
            }
            
            visited[i] = count + 1;
            solve(words[i], target, words, count + 1);
        }
    }
    
    static boolean transform(String begin, String target){
        boolean check = false;
        
        for(int i = 0; i < begin.length(); i++){   
            if(begin.charAt(i) != target.charAt(i)){
                if(check){
                    return false;
                }
                check = true;
            }
        }
        
        return check;
    }
}
