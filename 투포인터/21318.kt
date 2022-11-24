// [백준] 21318. 피아노 체조 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt() // 악보의 개수
    val dp = Array(n + 1) { 0 } // 실수하는지 여부
    val str = readLine().split(" ").map { it.toInt() } // 악보 나닝도
    var q = readLine().toInt() // 질문의 개수
    var sb = StringBuilder()

    for (i in 0 until str.size - 1) {
        dp[i + 1] = dp[i]
        // i번 째에서 i + 1번 으로 넘어갈 때 실수하는지
        if (str[i] > str[i + 1]) {
            dp[i + 1]++
        }
    }

    repeat(q){
        val tmp = readLine().split(" ").map { it.toInt() - 1}
        sb.append("${dp[tmp[1]] - dp[tmp[0]]}\n")
    }

    println(sb)
}
