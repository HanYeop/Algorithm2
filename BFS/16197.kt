import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

data class Info(var oneX: Int, var oneY: Int, var twoX: Int, var twoY: Int, var level: Int)
data class Pair(var x: Int, var y: Int)

// [백준] 16197. 두 동전 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }

    // 상우하좌
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, 1, 0, -1)
    val map = Array(n) { Array(m) { ' ' } }
//    val visited = Array(n) { Array(m) { Array(n) { Array(m) { false } } } }

    val coin = arrayListOf<Pair>()

    fun bfs() {
        val queue = LinkedList<Info>()
        queue.offer(Info(coin[0].x, coin[0].y, coin[1].x, coin[1].y, 1))

        while (queue.isNotEmpty()) {

            // 버튼을 10번보다 많이 눌러야 한다면
            if (queue.peek().level > 10) {
                println(-1)
                break
            }
            val cur = queue.pop()

            for (j in 0 until 4) {
                var nox = cur.oneX + dx[j]
                var noy = cur.oneY + dy[j]
                var ntx = cur.twoX + dx[j]
                var nty = cur.twoY + dy[j]

                // 동전이 하나 떨어졌을 때
                if ((nox < 0 || noy < 0 || nox >= n || noy >= m) xor
                    (ntx < 0 || nty < 0 || ntx >= n || nty >= m)
                ) {
                    println(cur.level)
                    return
                }
                // 둘다 떨어졌을 때
                if ((nox < 0 || noy < 0 || nox >= n || noy >= m) &&
                    (ntx < 0 || nty < 0 || ntx >= n || nty >= m)
                ) {
                    continue
                }

                // coin 1의 다음 루트가 벽일 때
                if (map[nox][noy] == '#') {
                    nox = cur.oneX
                    noy = cur.oneY
                }

                // coin 2의 다음 루트가 벽일 때
                if (map[ntx][nty] == '#') {
                    ntx = cur.twoX
                    nty = cur.twoY
                }

//                if (!visited[nox][noy][ntx][nty]) {
                    queue.offer(Info(nox, noy, ntx, nty, cur.level + 1))
//                    visited[nox][noy][ntx][nty] = true
//                }
            }
        }

//        println(-1)
    }

    // 맵 입력
    repeat(n) { x ->
        val str = readLine()
        for (i in 0 until m) {
            map[x][i] = str[i]

            // 코인 위치 저장
            if (str[i] == 'o') {
                coin.add(Pair(x, i))
            }
        }
    }
    bfs()
}
