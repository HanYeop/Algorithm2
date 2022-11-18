import java.util.*;

// [프로그래머스] 이중우선순위큐 (Java)
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for(String st: operations){
            String[] c = st.split(" ");
            
            int value = Integer.parseInt(c[1]);
            
            if(c[0].equals("I")){
                maxPq.offer(value);
                minPq.offer(value);
            }
            
            if(st.equals("D 1")){
                minPq.remove(maxPq.poll());
            }
            
            if(st.equals("D -1")){
                maxPq.remove(minPq.poll());
            }
        }
        
        answer = new int[2];
        
        if(!maxPq.isEmpty()){
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }

        return answer;
    }
}