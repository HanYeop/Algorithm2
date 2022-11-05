// [백준] 16562. 친구비 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.file.Files.find
import java.util.StringTokenizer
import kotlin.math.min

lateinit var parent: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m,k) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) {0} // 친구비
    parent = Array(n + 1) { it }
    val list = arrayListOf( arrayListOf<Int>()) // 친구 집합

    val st = StringTokenizer(readLine())

    for(i in 1 until arr.size){
        arr[i] = st.nextToken().toInt()
    }

    // 부모 묶어주기
    repeat(m){
        val (one, two) = readLine().split(" ").map { it.toInt() }
        union(one, two)
    }

    val visited = Array(n + 1) { false }
    for(i in 1 .. n){

        if(!visited[i]) {
            visited[i] = true
            val par = find(i)
            val tmp = arrayListOf(i)

            for (j in i + 1..n) {
                if (par == find(j)) {
                    tmp.add(j)
                    visited[j] = true
                }
            }

            list.add(tmp)
        }
    }

    var result = 0
    for(i in list){
        var min = Integer.MAX_VALUE

        for(j in i){
            min = min(min, arr[j])
        }

        result += if(min == Integer.MAX_VALUE) 0 else min
    }
    
    if(result <= k) println(result) else println("Oh no")
}


fun union(x: Int, y: Int){
    val nx = find(x)
    val ny = find(y)

    if(nx != ny){
        parent[ny] = nx
    }
}

// 최상위 노드 찾기
fun find(x: Int): Int{
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}
