// [프로그래머스] 네트워크 (Java)
class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n]; 
        
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }    
            answer++;
            visited[i] = true;
            solve(n, computers, i);
        }
        
        return answer;
    }
    
    static void solve(int n, int[][] computers, int start){
        for(int i = 0; i < n; i++){
            int next = computers[start][i];
            
            if(next != 1){
                continue;
            }
            
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            solve(n, computers, i);
        }
    }
}
