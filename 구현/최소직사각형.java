// [프로그래머스] 최소직사각형 (Java)
class Solution {
    static int max = Integer.MIN_VALUE;
    static int subMax = Integer.MIN_VALUE;
    
    static int maxIndex;
    static int minIndex;

    public int solution(int[][] sizes) {
        int answer = 0;
        
        findMax(sizes);
        
        if(maxIndex == 0){
            minIndex = 1;
        }
        
        swapAll(sizes);
        findMaxValue(sizes);
        
        answer = max * subMax;
        return answer;
    }
    
    static void findMax(int[][] sizes){
        for(int i = 0; i < sizes.length; i++){
            for(int j = 0; j < sizes[0].length; j++){
                if(sizes[i][j] > max){
                    max = sizes[i][j];
                    maxIndex = j;
                }
            }
        }
    }
    
    static void swapAll(int[][] sizes){
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][maxIndex] < sizes[i][minIndex]){
                int tmp = sizes[i][maxIndex];
                sizes[i][maxIndex] = sizes[i][minIndex];
                sizes[i][minIndex] = tmp;
            }
        }
    }
    
    static void findMaxValue(int[][] sizes){
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][minIndex] > subMax){
                subMax = sizes[i][minIndex];
            }
        }
    }
}
