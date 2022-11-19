import java.util.*;

// [프로그래머스] 게임 맵 최단거리 (Java)
class Pair{
    int x,y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    
    static int[][] map;
    static int n;
    static int m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        map = maps;
        
        answer = bfs();
        
        return answer;
    }
    
    static int bfs(){
        Queue<Pair> q = new LinkedList();
        
        q.offer(new Pair(0,0));
        int count = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            
            for(int k = 0; k < size; k++){
                Pair cur = q.poll();

                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    // 범위 벗어남
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                        continue;
                    }
                    
                    if(nx == n - 1 && ny == m - 1){
                        return count + 1;
                    }

                    if(map[nx][ny] != 0){
                        map[nx][ny] = 0;
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }
        
        return -1;
    }
}
