package baekjoon.bronze2;

import java.util.*;
import java.io.*;

public class P2966_240826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] corrects = new int[3]; // 3명이 문제를 맞춘 개수를 저장하는 배열
        String[] names = {"Adrian", "Bruno", "Goran"}; // 사람 이름을 저장하는 배열 (출력 순서를 위해 만들었다.)
        char[] choose1 = {'A', 'B', 'C'}; // Adrian 의 찍기 순서
        char[] choose2 = {'B', 'A', 'B', 'C'}; // Bruno 의 찍기 순서
        char[] choose3 = {'C', 'C', 'A', 'A', 'B', 'B'}; // Goran 의 찍기 순서

        int n = Integer.parseInt(br.readLine()); // 문제의 개수
        char[] problems = br.readLine().toCharArray(); // 입력받는 문자열(문제)를 문자 배열로 저장한다.

        for (int i = 0; i < problems.length; i++) { // 문제의 수만큼 반복
            char target = problems[i]; // 현재 문제 답

            // 해당 문제의 답을 맞출 경우 맞춘 사람의 맞춘 개수를 증가시킨다.
            // 사람마다 선택한 규칙을 순회하기 위해 (인덱스 % 규칙의 길이) 를 한다.
            if (choose1[i % 3] == target) corrects[0]++;

            if (choose2[i % 4] == target) corrects[1]++;

            if (choose3[i % 6] == target) corrects[2]++;
        }

        int max = 0; // 맞춘 문제의 최대개수를 담는 변수
        List<Integer> list = new ArrayList<>(); // 가장 많이 맞춘 사람의 인덱스를 담는 리스트
        // 리스트를 쓰는 이유는 몇명이 최대 개수를 맞춘지 알 수 없기 때문

        // 맞춘 문제의 최대 개수를 구하고
        for (int c : corrects) {
            max = Math.max(max, c);
        }


        // max 와 같은 인덱스를 list 에 저장
        for (int i = 0; i < 3; i++) {
            if (max == corrects[i]) list.add(i);
        }


        // 최대값을 출력하고
        System.out.println(max);
        for (int idx : list) { // 리스트에 저장된 인덱스에 해당하는 사람 이름을 출력한다.
            System.out.println(names[idx]);
        }
    }
}
