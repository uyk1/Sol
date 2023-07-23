import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // stages에는 '1이상 N + 1 이하'의 자연수!
        int[] arrive = new int[N+2];
        int[] fail = new int[N+2];
        for(int i: stages) {
            for(int j = 1; j <= i; j++) arrive[j]++;
            fail[i]++;
        }
        Map<Integer, Double> hm = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            if(arrive[i] == 0) {
                hm.put(i, 0.0);
                continue;
            }
            hm.put(i, (double) fail[i] / arrive[i]);
        }
        List<Integer> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(hm.get(o2), hm.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}