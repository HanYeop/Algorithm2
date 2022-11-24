import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

// [백준] 2504. 괄호의 값 (Kotlin)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var str = readLine()

    var pr = 1
    var sum = 0
    var stack = Stack<Char>()

    for((index, value) in str.withIndex()){
        when (value) {
            '(' -> {
                pr *= 2
                stack.add(value)
            }
            '[' -> {
                pr *= 3
                stack.add(value)
            }
            ')' -> {
                if(stack.isEmpty() || stack.peek() != '(') {
                    println(0)
                    return@with
                }else if(str[index - 1] == '('){
                    sum += pr
                }
                pr /= 2
                stack.pop()
            }
            ']' -> {
                if(stack.isEmpty() || stack.peek() != '[') {
                    println(0)
                    return@with
                }else if (str[index - 1] == '['){
                    sum += pr
                }
                pr /= 3
                stack.pop()
            }
        }
    }

    if(stack.isNotEmpty()) println(0)
    else println(sum)
}
