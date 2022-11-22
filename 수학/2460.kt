import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// [백준] 2460. 지능형 기차2 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var max = 0 // 최댓값
    var person = 0 // 현재 승객 인원

    for(i in 1 .. 10){
        val (minus,add) = readLine().split(" ").map { it.toInt() }
        person += (add - minus)

        max = max(max, person)
    }

    println(max)
}
