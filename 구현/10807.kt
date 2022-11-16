import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// [백준] 10807. 개수 세기 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val map = mutableMapOf<Int, Int>()

    val str = StringTokenizer(readLine())
    for(i in 0 until n){
        val num = str.nextToken().toInt()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val result = map[readLine().toInt()]
    if(result == null) println(0) else println(result)
}
