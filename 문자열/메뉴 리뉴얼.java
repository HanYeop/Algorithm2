import java.util.*;

class Pair implements Comparable<Pair>{
    String s;
    int count;
    
    public Pair(String s, int count){
        this.s = s;
        this.count = count;
    }
    
    @Override
	public int compareTo(Pair p) {
        return p.count - this.count;
	}
}

class Solution {
    
    static ArrayList<Pair> list;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> result = new ArrayList<>();
        
        list = new ArrayList<>();
        
        for(String str: orders){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            
            str = new String(cs);
            
            for(int i = 0; i < str.length(); i++){
                combi(String.valueOf(str.charAt(i)), i, str);
            }
        }  

        Collections.sort(list);
        
        for(int co: course){
            int max = -1;
            for(Pair p: list){
                int len = p.s.length();
                
                // 메뉴 조합
                if(len == co && p.count >= 2){
                    
                    if(max == -1 || p.count == max){
                        max = p.count;
                        result.add(p.s);
                    }
                    
                    if(p.count < max){
                        break;
                    }
                }
            }
        }
        
        Collections.sort(result);
        
        answer = new String[result.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    
    // cur = 새로 생성되는 문자, str = 원래 문자
    static void combi(String cur, int index, String str){
        
        // 이미 있는 조합인지 체크
        boolean check = false;
        
        for(Pair p : list){
            // 이미 있는 조합이면 ++
            if(p.s.equals(cur)){
                p.count += 1;
                check = true;
                break;
            }
        }
        
        // 없는 조합이면 새로 추가
        if(!check){
            list.add(new Pair(cur,1));
        }
        
        for(int i = index + 1; i < str.length(); i++){
            String tmp = cur + str.charAt(i);
            combi(tmp, i, str);
        }
    }
}