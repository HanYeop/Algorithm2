import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

// [백준] 16930. 달리기 (Kotlin)
var n = 0
var m = 0
var k = 0
var result = -1
val dx = listOf(-1,0,1,0)
val dy = listOf(0,1,0,-1)
lateinit var map : Array<Array<Char>>
lateinit var dist : Array<Array<Int>>

data class Pair(var x: Int, var y: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]

    map = Array(n) { Array(m) {'.'} }
    dist = Array(n) { Array(m) { Int.MAX_VALUE } }

    for(i in 0 until n){
        val str = readLine()
        for(j in 0 until m){
            map[i][j] = str[j]
        }
    }

    var(x1,y1,x2,y2) = readLine().split(" ").map { it.toInt() - 1 }

    bfs(Pair(x1,y1), Pair(x2,y2))

    println(result)
}

fun bfs(start: Pair, end: Pair){
    val queue: Queue<Pair> = LinkedList()
    queue.offer(start)

    var count = 1
    while(queue.isNotEmpty()){
        val size = queue.size

        for(i in 0 until size){
            val cur = queue.poll()

            for(j in 0 until 4){

                for(q in 1 .. k){
                    val nx = cur.x + (dx[j] * q)
                    val ny = cur.y + (dy[j] * q)

                    // 범위 벗어남
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m ){
                        break
                    }

                    // 더 큰 값이면 더이상 탐색 필요X
                    if(count > dist[nx][ny]){
                        break
                    }

                    // 벽이면 탐색 종료
                    if(map[nx][ny] == '#'){
                        break
                    }

                    // 최소 경로 갱신
                    if(count < dist[nx][ny]){
                        dist[nx][ny] = count
                        queue.offer(Pair(nx,ny))
                    }

                    // 정답 찾음
                    if(end.x == nx && end.y == ny){
                        result = count
                        return
                    }
                }

            }
        }
        count++
    }
}
