class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int dir = 1;
        if(direction.equals("left")) dir = -1;
        for(int i = 0; i < numbers.length; i++) {
            if(dir == 1){
                if(i != numbers.length-1) answer[i+1] = numbers[i];
                else answer[0] = numbers[i];
            } else {
                if(i != 0) answer[i-1] = numbers[i];
                else answer[numbers.length-1] = numbers[i];
            }
        }
        return answer;
    }
}