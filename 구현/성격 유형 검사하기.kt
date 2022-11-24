// [프로그래머스] 성격 유형 검사하기 (Kotlin)
class Solution {
    var RT = Array (2) {0} // 라이언형, 튜브형
    var CF = Array (2) {0} // 콘형, 프로도형
    var JM = Array (2) {0} // 제이지형, 무지형
    var AN = Array (2) {0} // 어피치형, 네오형

    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        
        for(i in 0 until survey.size){
            when(survey[i]){
                "RT" -> {
                    cal(RT, choices[i], false)
                }
                "TR" -> {
                    cal(RT, choices[i], true)
                }
                "CF" -> {
                    cal(CF, choices[i], false)
                }
                "FC" -> {
                    cal(CF, choices[i], true)
                }
                "JM" -> {
                    cal(JM, choices[i], false)
                }
                "MJ" -> {
                    cal(JM, choices[i], true)
                }
                "AN" -> {
                    cal(AN, choices[i], false)
                }
                "NA" -> {
                    cal(AN, choices[i], true)
                }
            }
        }
        val sb = StringBuilder()
        
        if(RT[0] >= RT[1]){
            sb.append("R")
        }else{
            sb.append("T")
        }
        
        if(CF[0] >= CF[1]){
            sb.append("C")
        }else{
            sb.append("F")
        }
        
        if(JM[0] >= JM[1]){
            sb.append("J")
        }else{
            sb.append("M")
        }
        
        if(AN[0] >= AN[1]){
            sb.append("A")
        }else{
            sb.append("N")
        }
        
        answer = sb.toString()
 
        return answer
    }
    
    fun cal(type: Array<Int>, score: Int, reverse: Boolean){
        var l = 0
        var r = 1
        if(reverse){
            l = 1
            r = 0
        }
        when(score){
            1 -> {
                type[l] += 3
            }
            2 -> {
                type[l] += 2
            }
            3 -> {
                type[l] += 1
            }
            5 -> {
                type[r] += 1
            }
            6 -> {
                type[r] += 2
            }
            7 -> {
                type[r] += 3
            }
            else ->{
                
            }
        }
    }
}
