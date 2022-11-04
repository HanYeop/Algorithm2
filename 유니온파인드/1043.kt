// [백준] 1043. 거짓말 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var parent: Array<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    
    val (n,m) = readLine().split(" ").map { it.toInt() } // 사람의 수, 파티의 수
    val arr = Array(n + 1) {false} // 진실 아는 사람
    var st = StringTokenizer(readLine())

    val party = Array (m) { arrayListOf<Int>() } // 파티 참여 인원 정보
    parent = Array(n + 1) {it} // 부모 정보

    val trueN = st.nextToken().toInt() // 진실을 아는 사람 수
    // 진실을 아는 사람
    repeat(trueN){
        val tmp = st.nextToken().toInt()
        arr[tmp] = true
    }

    // 파티 정보
    for(i in 0 until m){
        st = StringTokenizer(readLine())

        val pn = st.nextToken().toInt() // 파티 인원수

        for(j in 0 until pn){
            party[i].add(st.nextToken().toInt())

            // 파티 참여 인원들의 부모노드를 같게함
            if (j > 0) union(party[i][j], party[i][j - 1])
        }
    }

    for(i in 1 .. n){
        if(arr[i]){
            // 진실을 아는 사람 부모 정보
            val par = find(i)

            // 전체 탐색, 부모가 같다면 진실을 아는 사람에 추가
            for(j in 1 .. n){
                if(par == find(j)){
                    arr[j] = true
                }
            }
        }
    }

    val trueList = arrayListOf<Int>()
    for(i in arr.indices){
        if(arr[i]){
            trueList.add(i)
        }
    }

    var result = m
    for(i in 0 until m){
        // 파티 인원 중 진실을 아는 사람이 있다면 진실을 아는 파티
        for(j in party[i]){
            if(trueList.contains(j)){
                result--
                break
            }
        }
    }

    println(result)
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




