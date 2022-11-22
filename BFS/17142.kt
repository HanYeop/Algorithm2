import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import kotlin.math.max
import kotlin.math.min

// [백준] 17142. 연구소 3 (Kotlin)

var n = 0 // 연구소 크기
var m = 0 // 바이러스 개수
var min = Int.MAX_VALUE // 최소 시간
var blankSize = 0 // 감염 시켜야 하는 칸 개수
lateinit var map: Array<Array<Int>> // 연구소의 상태
val virus = arrayListOf<Point>() // 바이러스 활성화 가능한 위치
val list = arrayListOf<Point>() // 현재 활성화된 바이러스 위치

data class Point(var x: Int, var y: Int) // 좌표

var dx = listOf(-1,0,1,0)
var dy = listOf(0,-1,0,1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tmp = readLine().split(" ").map { it.toInt() }

    n = tmp[0]
    m = tmp[1]
    map = Array(n) { Array(n) { 0 } }

    // 맵 생성
    for(i in 0 until n){
        tmp = readLine().split(" ").map { it.toInt() }
        for(j in 0 until n){
            map[i][j] = tmp[j]
            if(tmp[j] == 0) blankSize++
            if(tmp[j] == 2) virus.add(Point(i,j)) // 바이러스 위치 기록
        }
    }

    // 처음부터 전부 감염되있을 때
    if(blankSize == 0){
        println(0)
    }else{
        combi(0, m)
        min = if(min == Int.MAX_VALUE) -1 else min // 전부 감염 불가능
        println(min)
    }
}

// 바이러스 활성화 가능한 수만큼을 뽑아 조합만듦
fun combi(index: Int, count: Int){
    if(count == 0){
        // 활성화 바이러스 방문처리
        var visited = Array(n) {Array(n) { false } }
        bfs(list, visited)
        return
    }
    for(i in index until virus.size){
        list.add(virus[i])
        combi(i + 1, count - 1)
        list.removeLast()
    }
}

// 사방탐색
fun bfs(list: ArrayList<Point>, visited: Array<Array<Boolean>>) {
    val queue = LinkedList<Point>()
    var result = blankSize // 현재 감염시켜야 하는 칸 개수

    for (i in list) {
        queue.offer(i)
        visited[i.x][i.y] = true
    }

    var count = 0
    while (queue.isNotEmpty()) {
        count++
        val size = queue.size

        for (k in 0 until size) {
            val cur = queue.poll()
            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                // 범위 초과
                if (nx !in 0 until n || ny !in 0 until n) {
                    continue
                }

                // 이미 방문한 곳
                if(visited[nx][ny]){
                    continue
                }

                // 벽
                if (map[nx][ny] == 1) {
                    continue
                }

                // 감염
                if (map[nx][ny] == 0) {
                    result--
                }

                // 방문 처리, 큐에 넣음
                visited[nx][ny] = true
                queue.offer(Point(nx, ny))

                // 전부 감염
                if (result == 0) {
                    min = min(min, count)
                    return
                }
            }
        }
    }
}
