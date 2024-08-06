package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sNum = Integer.parseInt(br.readLine());
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
