import java.util.*;

// [프로그래머스] 여행경로 (Java)
class Solution {
    
    static ArrayList<String> result;
    static int max;
    static String[] ans;
    static boolean[] visited;
    static String[][] _tickets;
    static boolean end = false;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        result = new ArrayList<>();
        max = tickets.length;
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> {
           if(o1[0].equals(o2[0])) {
               return o1[1].compareTo(o2[1]);
           } else {
               return o1[0].compareTo(o2[0]);
           }
        });
        
        _tickets = tickets;
        
        result.add("ICN");
        solve("ICN",1);

        answer = ans;
        return answer;
    }
    
    static void solve(String des, int count){   
        if(end){
            return;
        }
        
        if(count > max){
            ans = result.toArray(new String[0]);
            end = true;
            return;
        }
        
        for(int i = 0; i < max; i++){
            if(visited[i]){
                continue;
            }
            
            if(!des.equals(_tickets[i][0])){
                continue;
            }
            
            visited[i] = true;
            result.add(_tickets[i][1]);
            solve(_tickets[i][1], count + 1);
            visited[i] = false;
            result.remove(result.size() - 1);
        }
    }
}
