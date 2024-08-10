package baekjoon.bronze1;

import java.io.*;
import java.util.*;

/**
 * 초콜릿 자르기
 */
public class P2163 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = (n - 1) + n * (m - 1);

        System.out.println(answer);

    }
}
