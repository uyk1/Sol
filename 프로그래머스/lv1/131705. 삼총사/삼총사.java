class Solution {
    static int[] students;
    static boolean[] selected;
    static int answer;
    
    public int solution(int[] number) {
        answer = 0;
        students = number;
        selected = new boolean[number.length];
        
        comb(0, 0, 0);
        
        return answer;
    }
    
    static void comb(int start, int idx, int sum) {
        if(idx == 3) {
            if(sum == 0) answer++;
            return;
        }
        for(int i = start; i < students.length; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            comb(i + 1, idx + 1, sum + students[i]);
            selected[i] = false;
        }
    }
}
// 중복 없이 n개 중 m개 선택 -> 조합
// start는 기준.
// 뽑는 경우와 뽑지 않는 경우 모두 봐야 함.