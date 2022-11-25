import java.util.*
import kotlin.math.*

// [프로그래머스] 전력망을 둘로 나누기 (Kotlin)
class Solution {
    
    lateinit var map: Array<Array<Boolean>>
    var min = Int.MAX_VALUE
    
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = -1
        
        map = Array(n + 1) { Array(n + 1) {false} }
        
        // 송전탑 연결 맵
        for(i in wires){
            val one = i[0]
            val two = i[1]
            map[one][two] = true
            map[two][one] = true
        }
        
        for(i in wires){
            // 전선 끊음
            val one = i[0]
            val two = i[1]
            map[one][two] = false
            map[two][one] = false
            
            val o = solve(n, one)
            val t = n - o
            
            min = min(min, abs(o - t))            

            // 전선 다시 연결
            map[one][two] = true
            map[two][one] = true
        }
        
        answer = min
        return answer
    }
    
    // 전선 끊었을 때 계산 (bfs)
    fun solve(n: Int, start: Int): Int{
        
        val q: Queue<Int> = LinkedList()
        val visited = Array(n + 1) { false }
        var count = 1
        q.offer(start)
        visited[start] = true
        
        while(q.isNotEmpty()){
            val cur = q.poll()
            
            for(i in 1 .. n){
                // 이미 방문한 곳
                if(visited[i]){
                   continue 
                }
                
                // 연결되어 있는 곳
                if(map[cur][i] == true){
                    q.offer(i)
                    visited[i] = true
                    count++
                }
            }
        }
        
        return count
    }
}
