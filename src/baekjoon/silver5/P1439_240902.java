package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1439_240902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray(); // 입력 받은 문자열을 char 배열로 바꾼다.
        int changes = 0; // 이전 문자와 비교했을 때 변화되는 구간이 몇번 있었는지를 세는 변수
        char before = 0; // 이전 문자를 담는 변수
        for (char c : chars) { // 배열을 돌면서
            if (c != before) { // 이전 값과 현재 문자가 다르면
                before = c; // 이전 문자를 현재 값으로 수정하고
                changes++; // 변화된 수를 증가시킨다.
            }
        }

        System.out.println(changes / 2); // 변화된 수를 2로 나눈 후의 몫이 답이 된다.
    }
}
