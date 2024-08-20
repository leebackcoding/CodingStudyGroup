package baekjoon.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15953_240820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // 0 이 입력되면 상금을 못받는 다는 의미를 가지기 위해 {0, 0} 을 맨 처음 요소에 넣어준다.
        int[][] contest1 = {{0, 0}, {1, 5000000}, {3, 3000000}, {6, 2000000}, {10, 500000}, {15, 300000}, {21, 100000}};
        int[][] contest2 = {{0, 0}, {1, 5120000}, {3, 2560000}, {7, 1280000}, {15, 640000}, {31, 320000}};


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            String[] input = br.readLine().split(" ");

            int first = Integer.parseInt(input[0]); // 첫번째 대회 등수
            int second = Integer.parseInt(input[1]); // 두번째 대회 등수

            int money = 0;

            // 첫번째 대회 에 대한 상금
            for (int[] c1 : contest1) {
                if (first <= c1[0]) {
                    money += c1[1];
                    break;
                }
            }

            // 두번째 대회에 대한 상금
            for (int[] c2 : contest2) {
                if (second <= c2[0]) {
                    money += c2[1];
                    break;
                }
            }

            sb.append(money).append("\n");
        }

        System.out.print(sb.toString());
    }
}
