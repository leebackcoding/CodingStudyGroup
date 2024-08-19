package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8월 20일 코테 문제
public class P1333_240820 {
    public static void main(String[] args) throws IOException {
        // 시간 효율성을 위해서 BufferedReader 를 사용한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer 를 사용해서 한 줄로 입력받은 문자열을 띄어쓰기 단위로 잘라서 입력받았다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 하나씩 N, L, M 에 int 로 바꿔서 저장한다.
        int N = Integer.parseInt(st.nextToken()); // 노래의 개수
        int L = Integer.parseInt(st.nextToken()); // 노래의 길이
        int M = Integer.parseInt(st.nextToken()); // 전화벨이 울리는 간격


        int bellTime = 0; // 전화벨이 울리는 시간
        int now = 0; // 현재 시간
        int answer = 0; // 이 문제의 답

        // 남은 노래가 있는 상태에서 전화를 받을 수 있다면 true
        // 모든 노래를 다 들었는데도 전화를 받지 못했다면 false
        boolean flag = false;

        while(N > 0) { // 남은 노래의 개수가 0이 되면 while 반복문 종료
            N--; // 반복문을 돌 때마다 남은 노래의 개수를 1씩 줄인다.

            /*
             *  0초에서 시작해서 반복문 마다 L초씩 더한다.
             * 이 시간 범위동안은 전화를 받을 수 없기에 한번에 시간을 추가해준다.
             */
            now += L;

            while (bellTime < now) { // 전화가 울리는 시간이 현재시간보다 작다면
                bellTime += M; // 전화가 울리는 간격을 bellTime 에 더해준다.
            }

            // 전화벨이 울리는 시간이 노래가 끝나는 시간부터 노래가 시작하기 1초전까지 범위에 해당한다면
            if (bellTime >= now && bellTime <= now + 4) {
                answer = bellTime; // 해당 전화벨이 울리는 시간이 정답이 된다.
                flag = true; // 모든 노래가 나오기 전에 전화를 받았기 때문에 flag 를 true 로 변경한다.
                break; // 전화를 받았기 때문에 더 이상의 반복은 의미가 없으므로 반복문을 빠져나간다.
            }

            now += 5; // 해당 노래 쉬는시간에 전화를 받지 못했다면 다음 노래가 나오는 시간으로 현재 시간을 바꿔준다.
        }


        // flag 가 false 일 경우에 해당 조건문이 실행이 되는데
        // flag 가 false 라는 것은 모든 노래가 다 나오고 나서도 전화를 받지 못했다는 것이다.
        if(!flag) {
            // bellTime 은 위 반복문에서 현재시간보다 작다면 계속 전화벨이 울리는 간격(M초) 만큼 증가시켜왔기에
            // 반복문을 빠져나오고 나서의 bellTime 이 정답이 된다.
            answer = bellTime;
        }

        // 정답을 출력한다.
        System.out.println(answer);

    }

}
