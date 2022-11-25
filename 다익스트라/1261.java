import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

// [백준] 1261. 알고스팟 (Kotlin)
var m = 0 // 가로 크기
var n = 0 // 세로 크기
lateinit var map: Array<Array<Int>>
lateinit var dist: Array<Array<Int>>

val dx = listOf(-1,0,1,0)
val dy = listOf(0,1,0,-1)

data class Node(val x: Int, val y: Int, val count: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())

    m = st.nextToken().toInt()
    n = st.nextToken().toInt()
    map = Array(n) {Array(m) { 0 } }
    dist = Array(n) {Array(m) { Int.MAX_VALUE } }
    dist[0][0] = 0

    for(i in 0 until n){
        val str = readLine()
        for(j in 0 until m){
            map[i][j] = str[j].toString().toInt()
        }
    }

    bfs()
    println(dist[n - 1][m - 1])
}

fun bfs(){
    val q: Queue<Node> = LinkedList()
    q.offer(Node(0,0,0))

    while(q.isNotEmpty()){
        val cur = q.poll()

        for(i in 0 until 4){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            var count = cur.count

            // 범위 초과
            if(nx !in 0 until n || ny !in 0 until m){
                continue
            }

            // 벽이면
            if(map[nx][ny] == 1){
                count++
            }

            // 더 적은 벽을 부술 수 있는 경로
            if(count < dist[nx][ny]){
                dist[nx][ny] = count
                q.offer(Node(nx, ny, count))
            }
        }
    }
}