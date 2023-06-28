class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] list = { 
           ".-","-...","-.-.", "-..",".","..-.",
            "--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-",
            "-.--","--.."
        };
        String[] morse = letter.split(" ");
        for(String str: morse) {
            for(int i = 0; i < list.length; i++) {
                if(str.equals(list[i])) {
                    answer += Character.toString('a' + i);
                    break;
                }
            }
        }
        
        return answer;
    }
}