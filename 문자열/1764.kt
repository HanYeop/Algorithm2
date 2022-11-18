import java.io.BufferedReader
import java.io.InputStreamReader

// [백준] 1764. 듣보잡 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Int>()
    var count = 0

    repeat(n + m){
        val str = readLine()
        if(map.getOrDefault(str, 0) == 1){
            count++
        }
        map[str] = map.getOrDefault(str, 0) + 1
    }

    val result = map.toList().sortedBy { it.first }

    println(count)
    for(i in result){
        if(i.second == 2){
            println(i.first)
        }
    }
}
