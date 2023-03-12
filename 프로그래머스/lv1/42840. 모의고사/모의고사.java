import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] cnt = new int[3];
        int[] chk1 = {1,2,3,4,5,1,2,3,4,5};
        int[] chk2 = {2,1,2,3,2,4,2,5};
        int[] chk3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i = 0; i < answers.length; i++) {
            int idx = i%10;
            if(answers[i] == chk1[idx]) cnt[0]++;
            if(answers[i] == chk3[idx]) cnt[2]++;
            int idx2 = i%8;
            if(answers[i] == chk2[idx2]) cnt[1]++;
        }
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2])); //최댓값
        for(int i = 0; i < 3; i++) {
            if(max == cnt[i]) ans.add(i+1);
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
        Arrays.sort(answer);
        return answer;
    }
}