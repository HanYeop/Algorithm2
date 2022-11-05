class Solution {
    fun solution(A: String, B: String): Int {
        var answer: Int = 0
        val len = A.length
        var a = A
        var count = 0
        answer = -1
        
        if(A == B) return 0
        
        repeat(len - 1){
            count++
            
            val sb = StringBuilder()
            sb.append(a[len - 1])
            
            for(i in 0 until len - 1){
                sb.append(a[i])
            }
            
            a = sb.toString()
            
            if(a == B){
                answer = count
                return answer
            }
        }
        
        return answer
    }
}
