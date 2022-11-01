import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        int deTime = fees[0];
        int deFee = fees[1];
        int coTime = fees[2];
        int coFee = fees[3];
    
        // 차 이동 내역
        Map<String,Integer> car = new HashMap<>();

        // 차 누적 주차 시간
        Map<String,Integer> map = new HashMap<>();
        
        // 차 상태 체크
        Map<String,Boolean> check = new HashMap<>();
        
        int maxTime = 23 * 60 + 59;
        
        for(String str : records){
            StringTokenizer st = new StringTokenizer(str);    
            String time = st.nextToken();
            String number = st.nextToken(); // 차 번호
            String type = st.nextToken(); // In, Out

            // 실제 시간 구하기(분)
            String[] tmp = time.split(":");
            int timeValue = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            
            if(type.equals("IN")){
                car.put(number, timeValue);
                check.put(number, true);         
            }else if(type.equals("OUT")){
                int value = timeValue - car.get(number); // 실제 이용 시간
                car.put(number, 0);
                map.put(number, map.getOrDefault(number, 0) + value);
                check.put(number, false);
            }
        }
        
        for (String i: check.keySet()) {
            // 출차 안된 차는 자동 계산
            if(check.get(i)){
                int value = maxTime - car.get(i); // 실제 이용 시간
                map.put(i, map.getOrDefault(i, 0) + value);
            }
        }

        
        ArrayList<String> str = new ArrayList<>();
        for (String i: map.keySet()){
            str.add(i);
        }  
        
        Collections.sort(str);
        answer = new int[str.size()];
        int index = -1;
        
        for(String s: str){      
            index++;
            int value = map.get(s);
            value -= deTime;
            
            // 기본 시간
            if(value <= 0){
                answer[index] = deFee;
                continue;
            }
            
            // 딱 나눠 떨어지면
            if(value % coTime == 0){
                value /= coTime;
            }else{
                value = (value / coTime) + 1;
            }
            answer[index] = deFee + (value * coFee);
        }
        
        
        return answer;
    }
}