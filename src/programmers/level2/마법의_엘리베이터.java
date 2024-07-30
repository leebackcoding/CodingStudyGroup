package programmers.level2;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        char[] charArr = String.valueOf(storey).toCharArray();
        boolean over = false;
        for(int i = charArr.length - 1; i >= 0; i--){
            int num = charArr[i] - '0';
            if(over) {
                num++;
                if(num == 10) {
                    over = true;
                    continue;
                }
                over = false;
            }
            if(num > 5 || num == 5 && (i == 0 || charArr[i - 1] >= '5')) {
                answer += 10 - num;
                over = true;
            } else {
                answer += num;
                over = false;
            }

        }
        if (over) answer++;

        return answer;
    }
}
