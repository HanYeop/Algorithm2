// [프로그래머스] 피로도 (Java)
class Solution {
    
    static int result = 0;
    static int size;
    static int[][] dun;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dun = dungeons;
        size = dungeons.length;
        visited = new boolean[size];
        
        solve(k, 0);
        
        answer = result;
        return answer;
    }
    
    // 현재 피로도,  최소 피로도, 소모 피로도
    static void solve(int piro, int count){
        
        if(count == size){
            result = Math.max(result, count);
            return;
        }
        
        for(int i = 0; i < size; i++){  
            
            if(visited[i]){
                continue;
            }        
            
            if(piro < dun[i][0]){
                result = Math.max(result, count);
                continue;
            }
                 
            visited[i] = true;
            solve(piro - dun[i][1], count + 1);
            visited[i] = false;
        }
    }
}
