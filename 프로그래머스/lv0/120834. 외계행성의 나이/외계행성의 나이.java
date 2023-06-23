class Solution {
    public String solution(int age) {
        String answer = "";
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        String sAge = String.valueOf(age);
        for(int i = 0; i < sAge.length(); i++) answer += arr[Integer.parseInt(sAge.substring(i, i+1))];
        return answer;
    }
}