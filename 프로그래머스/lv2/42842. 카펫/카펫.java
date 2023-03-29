class Solution {
    public int[] solution(int brown, int yellow) {
        //yellow는 1일 수 있으므로 <= 까지!
        for(int i = 1; i <= yellow; i++) {
            if(yellow%i != 0) continue;
            if(2 * (i + yellow/i) + 4 == brown){
                return new int[]{Math.max(i,yellow/i)+2,Math.min(i,yellow/i)+2};
            }
        }
        return null;
    }
}