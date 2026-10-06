// PROGRAMMERS #42842 · 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
// Language: java

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int height = 1 ; height * height <= yellow ; height++){
            if(yellow % height != 0){
                continue;
            }
            int width = yellow / height;
            int expectedBrown = width * 2 + height * 2 + 4;
            if(brown == expectedBrown){
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        
        return answer;
    }
}

//probe8