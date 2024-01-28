import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; // 0: best, 1: worst
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        List<Integer> list = new ArrayList<>();
        for(int i: win_nums) list.add(i);
        
        for(int i: lottos) {
            if(list.contains(i)) {
                answer[0]++;
                answer[1]++;
            }
            if(i == 0) {
                answer[0]++;
            }
        }
        
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        
        return answer;
    }
}