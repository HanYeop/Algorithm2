import java.io.BufferedReader
import java.io.InputStreamReader

// [백준] 5597. 과제 안 내신 분..? (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = Array (30 + 1) { false }

    repeat(28){
        arr[readLine().toInt()] = true
    }

    for(i in 1 until arr.size){
        if(!arr[i]) println(i)
    }
}
