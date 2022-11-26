import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// [백준] 1717. 집합의 표현 (Kotlin)
var n = 0 // 집합 개수
var m = 0 // 연산 개수
lateinit var parent: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    parent = Array(n + 1) { it }
    val sb = StringBuilder()

    repeat(m){
        st = StringTokenizer(readLine())
        val type = st.nextToken().toInt()
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        // 부모를 같게함
        if(type == 0) {
            union(a,b)
        }else if(type == 1){
            // 부모가 같으면 YES
            if(find(a) == find(b)){
                sb.append("YES\n")
            }
            // 다르면 NO
            else{
                sb.append("NO\n")
            }
        }
    }

    println(sb)
}

fun union(x:Int, y: Int){
    val nx = find(x)
    val ny = find(y)

    if(nx != ny){
        parent[nx] = ny
    }
}

fun find(x: Int): Int{
    if(x == parent[x]) return x

    parent[x] = find(parent[x])
    return parent[x]
}
