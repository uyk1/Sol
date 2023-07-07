class Solution {
    public String solution(int[] food) {
        String a = "", b = ""; // 전반부, 후반부
        for(int i = 1; i < food.length; i++) {
            a += String.valueOf(i).repeat(food[i] / 2);
            String tmp = b;
            b = String.valueOf(i).repeat(food[i] / 2) + tmp;
        }
        return a + "0" + b;
    }
}