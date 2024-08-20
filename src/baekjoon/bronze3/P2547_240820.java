package baekjoon.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2547_240820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0;  i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            long sum = 0L; // 합게 : int 로 받아도 상관 없을 거 같다.

            // 입력받은 수를 그저 덥셈을 하게 되면 long 범위를 넘게 되므로
            // 입력받으면서 바로 N으로 나머지 연산을 하고 나서 sum 에 더해주었다.
            // 이렇게 진행하고 나서 sum 이 N 으로 나누어 떨어지는지 확인하면 된다.
            for (int j = 0; j < N; j++) {
                sum += Long.parseLong(br.readLine()) % N;
            }

            if (sum % N == 0) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");

            if (i < T - 1) br.readLine();
        }

        System.out.println(sb);
    }


    // 처음에는 double 로 모두 더해서 소수점 아래를 문자열로 치환하고
    // 치환된 문자열이 모두 0으로만 이루어져 있는지로 나누어떨어짐을 증명하려고 하였다.
    // 하지만 double 의 불명확성이 존재해서 실패하였다.

    /*double sum = 0.0;
            for (int j = 0; j < N; j++) {
                sum += Long.parseLong(br.readLine());
            }

            double avg = sum / N;

            String avgStr = String.valueOf(avg);
            String bottom = avgStr.substring(avgStr.indexOf('.') + 1);
            String replaceStr = bottom.replace("0", "");

            if (replaceStr.isEmpty()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");

//            System.out.println(replaceStr);

//            long target = Long.parseLong(bottom);
//
//            if (target != 0L) {
//                sb.append("NO");
//            } else {
//                sb.append("YES");
//            }
//            sb.append("\n");*/
}
