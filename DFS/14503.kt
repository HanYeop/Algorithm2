import java.io.BufferedReader
import java.io.InputStreamReader

// [백준] 14503. 로봇 청소기 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 세로 크기, 가로 크기
    val (n,m) = readLine().split(" ").map { it.toInt() }
    // 로봇 청소기가 청소하는 칸의 개수
    var count = 0
    // 로봇 최초 위치, 방향 (0123 = 북동남서)
    val robot = readLine().split(" ").map { it.toInt() }
    // 장소의 상태
    val map = Array (n) { Array (m) { 0 } }

    // 0 - 서남동북 0123
    val dx = listOf(0,1,0,-1)
    val dy = listOf(-1,0,1,0)

    // 뒤로 가야할 때(남서북동)
    val bx = listOf(1,0,-1,0)
    val by = listOf(0,-1,0,1)

    // 장소 상태 입력
    for(i in 0 until n){
        val str = readLine().split(" ").map { it.toInt() }
        for(j in 0 until m){
            map[i][j] = str[j]
        }
    }

    // 현재 x,y,방향
    var curX = robot[0]
    var curY = robot[1]
    var curDir = robot[2]

    while(true){
        val start = (4 - curDir)
        var stop = true

        // 청소 안된 현재 위치 청소, count
        if(map[curX][curY] == 0){
            map[curX][curY] = 2 // 2 = 청소됨
            count++
        }

        for(i in start until start + 4){
            val next = i % 4
            val nx = curX + dx[next]
            val ny = curY + dy[next]

            // 벽이 아니고, 청소 안한 곳
            if(map[nx][ny] == 0){
                curX = nx
                curY = ny
                stop = false
                curDir = 3 - next
                break
            }
        }

        // 이동 한 경우
        if(!stop) {
            continue
        }
        // 이동하지 못한 경우
        else{
            // 보는 방향에서 뒤로 감
            val nx = curX + bx[curDir]
            val ny = curY + by[curDir]

            // 벽이면 (종료)
            if(map[nx][ny] == 1){
                break
            }

            // 뒤로 감
            curX = nx
            curY = ny
        }
    }

    println(count)
}
