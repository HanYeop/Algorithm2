import java.util.*;

// [프로그래머스] 두 개 뽑아서 더하기 (Java)
class Solution {
    
    static TreeSet<Integer> set;
    static int[] list;
    
    public int[] solution(int[] numbers) {
        int[] answer = {};
        set = new TreeSet<>();
        list = new int[2];
        
        combi(0, 0, numbers);
        
        answer = new int[set.size()];
        int count = 0;
        for(int i: set){
            answer[count++] = i;
        }
        
        return answer;
    }
    
    static void combi(int start, int count, int[] numbers){
        if(count == 2){
            find();    
            return;
        }        
        
        for(int i = start; i < numbers.length; i++){
            list[count] = numbers[i];
            combi(i + 1, count + 1, numbers);
        }
    }
    
    static void find(){
        int sum = 0;
        
        for(int i: list){
            sum += i;
        }
        
        set.add(sum);
    }
}
