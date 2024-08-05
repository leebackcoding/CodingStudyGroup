package baekjoon.silver5;

import java.util.Scanner;

public class P1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 가지고 싶은 막대 길이 입력 받기
        int x = 64; // 최초 막대 길이는 64cm
        int count = 1; // 막내는 무조건 1개는 들고 있으니 1개 들고 시작
        while (x != n) { // 막대 길이가 같으면 더 이상 막대를 자를 필요 없어서 반복 종료
            if(x > n) { // 현재 가지고 있는 막대의 길이가 n
                x /= 2;
            } else if(x < n) {
                n -= x;
                count++;
            }
        }

        System.out.println(count);
    }
}
