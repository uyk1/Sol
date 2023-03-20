import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add((100-progresses[i])%speeds[i] > 0 ? (100-progresses[i])/speeds[i] + 1 : (100-progresses[i])/speeds[i]);
        } 
        while(!q.isEmpty()) {
            int tmp = 1;
            int chk = q.poll();
            while(!q.isEmpty() && chk >= q.peek()) {
                tmp++;
                q.poll();
            }
            ans.add(tmp);
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i); 
        
        return answer;
    }
}