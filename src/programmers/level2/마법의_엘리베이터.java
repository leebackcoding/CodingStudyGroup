package programmers.level2;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        // storey 를 낮은 자리 숫자에서 부터 검사를 시작한다.
        while(storey > 0){
            int low = storey % 10; // 제일 낮은 자리의 숫자
            storey /= 10; // 제일 낮은 숫자를 없앤다.

            int sumNum = 0; // 현재 자리에서 더할 숫자
            // 현재 자리의 숫자가 5보다 크면 무조건 올림을 한다.
            // 현재 자리의 숫자가 5이면 다음 자리를 검사한다.
            // 만약 다음 자리의 숫자가 5이상이면 현재 자리를 올림한다.
            if(low > 5 || (low == 5 && (storey % 10) >= 5)) {
                sumNum = 10 - low; // 올림 하니까 10 - low 만큼 추가한다.
                storey++; // 다음 자리의 숫자를 1 증가시킨다.
            } else { // 현재 자리의 숫자가 5미만인 경우
                sumNum = low; // 내림을 하기 위해 low 만큼 추가한다.
            }
            answer += sumNum; // 추가할 돌의 개수를 answer 에 더한다.

        }

        return answer;
    }
}
