import java.io.BufferedReader
import java.io.InputStreamReader

// [백준] 3460. 이진수 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val T = readLine().toInt()

    repeat(T){
        var n = readLine().toInt()
        var count = 0
        while(n > 0){
            if(n % 2 == 1) print("$count ")
            n /= 2
            count++
        }
    }
}
