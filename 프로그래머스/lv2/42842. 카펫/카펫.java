class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //yellow는 1일 수 있으므로 <= 까지!
        for(int i = 1; i <= yellow; i++) {
            if(yellow%i != 0) continue;
            int tmp = yellow/i;
            int r, h;
            if(2 * i + 2 * (tmp + 2) == brown){
                if(i + 2 <= tmp + 2) {
                    answer[0] = tmp + 2;
                    answer[1] = i + 2;
                } else {
                    answer[0] = i + 2;
                    answer[1] = tmp + 2;
                }
                break;
            }
        }
        
        return answer;
    }
}