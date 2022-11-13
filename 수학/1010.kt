// [백준] 1010. 다리 놓기 (Java)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()

    fun combi(start: Int, repeat: Int): Long{
        var sum = start.toLong()
        var count = start

        repeat(repeat){
            sum *= (--count)
        }
        
        return sum
    }

    for(i in 0 until t){
        val (n,m) = readLine().split(" ").map { it.toInt() }

        val min = min(n, m - n)
        if(min == 0) {
            println(1)
            continue
        }
        val result = combi(m, min - 1) / combi(min, min - 1)
        println(result)
    }
}