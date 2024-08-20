package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 손익분기점
public class P1712_240820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 초기 비용
        int B = Integer.parseInt(st.nextToken()); // 1대 생산 비용
        int C = Integer.parseInt(st.nextToken()); // 1대 판매 비용

        // 손익 분기점 : 초기 비용 / (1대 판매비용 - 1대 생산 비용) + 1
        // 만약 1대 팔때 마다 손해를 보거나 수익이 없다면 구조라면 -1을 리턴하도록 한다.
        if (C - B <= 0)  {
            System.out.println(-1);
        }else {
            int answer = A / (C - B) + 1;
            System.out.println(answer);
        }


    }
}
