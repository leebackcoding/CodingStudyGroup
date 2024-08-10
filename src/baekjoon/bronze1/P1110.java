package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 같은 수가 되는 연산 횟수 구하기
 */
public class P1110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sNum = Integer.parseInt(br.readLine()); // String -> int
        int tmp = sNum;
        int count = 0;

        do {
            count++;
            int newTmp = (tmp / 10) + (tmp % 10);
            tmp =  Integer.parseInt("" + tmp % 10 + newTmp % 10);
        } while (sNum != tmp);

        System.out.println(count);
    }

}
