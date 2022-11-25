import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// [백준] 3085. 사탕 게임 (Kotlin)
var n = 0 // 보드의 크기
var max = Int.MIN_VALUE // 사탕 최대 가수

// 상하좌우
val dx = listOf(-1,1,0,0)
val dy = listOf(0,0,-1,1)

lateinit var map: Array<Array<String>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    map = Array(n) {Array(n) {""} }

    // 맵 입력
    for (i in 0 until n) {
        val str = readLine()
        for (j in 0 until n) {
            map[i][j] = str[j].toString()
        }
    }

    for(i in 0 until n){
        for(j in 0 until n){
            solve(i,j)
        }
    }

    println(max)
}

fun solve(x: Int, y: Int){

    val cur = map[x][y]
    max = max(max,1 + find(x, y, 2, cur) + find(x, y, 3, cur))
    max = max(max,1 + find(x, y, 0, cur) + find(x, y, 1, cur))

    for(i in 0 until 4){
        // 스왑할 좌표
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(!range(nx, ny)){
            continue
        }
        val swap = map[nx][ny]

        // 바꾼 방향의 좌우 탐색 (상하 = 좌우)
        if(i < 2){
            max = max(max,1 + find(x, y, 2, swap) + find(x, y, 3, swap))
        }else{
            max = max(max,1 + find(x, y, 0, swap) + find(x, y, 1, swap))
        }

        // 바꾼쪽의 반대쪽으로 탐색
        if(i % 2 == 0){
            max = max(max, 1 + find(x, y, (i + 1), swap))
        }else{
            max = max(max, 1 + find(x, y, (i - 1), swap))
        }
    }
}

// 범위에 포함되면 true
fun range(x: Int, y: Int): Boolean{
    return (x in 0 until n && y in 0 until n)
}

// 한 방향으로 계속 가면서 최대값 탐색
fun find(x: Int, y: Int, dir: Int, cur: String): Int{
    var sum = 0
    for(i in 1 until n){
        val nx = x + (dx[dir] * i)
        val ny = y + (dy[dir] * i)

        // 범위 벗어나면
        if(!range(nx,ny)){
            break
        }

        // 같은 사탕이 아니라면
        if(map[nx][ny] != cur){
            break
        }
        sum++
    }
    return sum
}
