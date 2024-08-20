package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1453_240820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 피시방에 온 손님 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> pc = new HashSet<Integer>(); // set 을 통해 손님이 요청한 죄석을 저장한다.

        while (st.hasMoreTokens()) { // 손님 수만큼 반복을 돌면서
            pc.add(Integer.parseInt(st.nextToken())); // 손님이 요청한 죄석을 pc 에 저장한다.
        }

        // pc 에 저장된 좌석 번호의 개수를 손님 수에서 빼면 나머지는 중복된 좌석을 요청한 것이다.
        // 즉 거절당한 손님의 수가 된다.
        System.out.println(n - pc.size());
    }

}
