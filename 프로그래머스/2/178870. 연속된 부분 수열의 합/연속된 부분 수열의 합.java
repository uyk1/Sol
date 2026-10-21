class Solution {
    /*
    부분 수열의 합이 정해져 있으므로 두 가지 조건만 확인
    1. 부분 수열로 이어지는가
    2. 부분 수열의 합이 k인가
    그리고 부분 수열의 합이 k에 도달할 경우, 해당 부분 수열의 길이를 확인해 현재까지의 답과 비교.
    !! 투 포인터 이용.
    */
    
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int sum = 0;

        int answerStart = 0;
        int answerEnd = sequence.length - 1;
        
        for(int end = 0; end < sequence.length; end++) {
            sum += sequence[end];
            
            while(sum > k) {
                sum -= sequence[start];
                start++;
            }
            
            if(sum == k) {
                if(end - start < answerEnd - answerStart) {
                    answerStart = start;
                    answerEnd = end;
                }
                sum -= sequence[start];
                start++;
            }
        }
        
        return new int[] {answerStart, answerEnd};
    }
}