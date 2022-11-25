import java.io.BufferedReader
import java.io.InputStreamReader

// [백준] 1789. 수들의 합 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine().toLong()
    var count = 1
    var sum = 0L

    while(sum < s){
        sum += count++
    }

    if(sum == s) println(count - 1)
    else println(count - 2)
}

