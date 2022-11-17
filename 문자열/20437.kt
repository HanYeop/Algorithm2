import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

// [백준] 20437. 문자열 게임 2 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()

    repeat(t){
        val w = readLine()
        val k = readLine().toInt()
        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE

        val hashMap = HashMap<Char, ArrayList<Int>>()

        for(i in w.indices){
            val key = w[i]

            // 알파벳 인덱스를 해시맵에 담음
            if(hashMap[key] == null){
                hashMap[key] = arrayListOf(i)
            }else {
                hashMap[key]!!.add(i)
            }
        }

        // 0번째부터 k 길이만큼 갈 수 있는지 체크, 최대 최소 확인
        for(i in hashMap){
            for(j in 0 until i.value.size - k + 1){
                val result = i.value[j + k - 1] - i.value[j]
                min = min(min, result)
                max = max(max, result)
            }
        }

        // 못 찾은 경우
        if(min == Int.MAX_VALUE || max == Int.MIN_VALUE){
            println(-1)
        }else{
            println("${min + 1} ${max + 1}")
        }
    }

}
