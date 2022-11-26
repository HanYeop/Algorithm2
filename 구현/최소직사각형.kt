import kotlin.math.*

// [프로그래머스] 최소직사각형 (Kotlin)
class Solution {
    
    // 최소 가로세로
    var minOne = 0
    var minTwo = 0
    
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        
        minOne = 0
        minTwo = 0
        
        for(i in 0 until sizes.size){
            val one = sizes[i][0]
            val two = sizes[i][1]
            
            if(one > two){
                minOne = max(minOne,one)
                minTwo = max(minTwo,two)
            }else{
                minOne = max(minOne,two)
                minTwo = max(minTwo,one) 
            }
        }
        answer = minOne * minTwo
        
        return answer
    }
}
