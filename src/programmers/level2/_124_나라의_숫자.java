package programmers.level2;

public class _124_나라의_숫자 {
    public String solution(int n) {

        char[] n124 = {'1', '2', '4'}; // 사용할 수 있는 숫자 1, 2, 4
        StringBuilder sb = new StringBuilder(); // StringBuilder 로 메모리 효율성 높임
        int n1 = 0;
        while(n > 0) {
            n1 = n % 3; // 받은 숫자의 나머지를 구한다.
            n /= 3; // 다음 숫자를 만든다.
            if(n1 == 0) { // 나머지가 0이라면 '4'라는 숫자가 들어가야하는데
                // 여기서 문제는 몫이 1이상일 수 있어서 나머지가 0이라면 1을 꼭 빼줘야한다.
                n1 = 4;
                n--;
            }

            sb.append(n1);
        }

        sb.reverse(); // 반대로 들어가 있기 때문에 마지막에 reverse 를 해준다.
        return sb.toString(); // toString 을 통해 반환타입을 맞춰서 반환한다.
    }
}
