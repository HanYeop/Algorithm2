import java.io.BufferedReader
import java.io.InputStreamReader

// state -1: 가로, 0: 대각선, 1: 세로
// x,y 끝점의 위치
data class Pipe(var x: Int, var y: Int, var state: Int)

// 가로일 때 : 가로, 대각선 이동
val Rd = listOf(Pipe(0, 1, -1), Pipe(1, 1, 0))

// 대각선일 때 : 가로, 세로, 대각선 이동
val Dd = listOf(Pipe(0, 1, -1), Pipe(1, 0, 1), Pipe(1, 1, 0))

// 세로일 때 : 세로, 대각선 이동
val Cd = listOf(Pipe(1, 0, 1), Pipe(1, 1, 0))


// [백준] 17070. 파이프 옮기기 1 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val map = Array(n) { Array(n) { 0 } }
    var count = 0

    fun dfs(cur: Pipe) {
        // 목표지점 도달
        if (cur.x == n - 1 && cur.y == n - 1) {
            count++
            return
        }

        var tmpList = Rd

        when (cur.state) {
            -1 -> tmpList = Rd
            0 -> tmpList = Dd
            1 -> tmpList = Cd
        }

        for(i in tmpList){
            val nx = cur.x + i.x
            val ny = cur.y + i.y

            // 범위를 벗어나면
            if(nx >= n || ny >= n){
                continue
            }
            // 벽이면
            if(map[nx][ny] == 1 || map[nx][cur.y] == 1 || map[cur.x][ny] == 1 ){
                continue
            }

            // DFS
            dfs(Pipe(nx, ny, i.state))
        }

    }

    for (i in 0 until n) {
        val tmp = readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            map[i][j] = tmp[j]
        }
    }

    dfs(Pipe(0, 1, -1))
    println(count)
}
