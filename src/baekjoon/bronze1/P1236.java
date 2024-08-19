package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1236 {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 4 4

        int row = Integer.parseInt(st.nextToken()); // 행
        int col = Integer.parseInt(st.nextToken()); // 열

        char[][] castle = new char[row][col];
        boolean[] rows = new boolean[row]; // 행 false : x가 없음
        boolean[] cols = new boolean[col]; // 열 false : x가 없음

        for(int i = 0; i < row; i++) {
            String string = br.readLine(); // 한 행을 문자열로 입력
            char[] ch = string.toCharArray(); // 문자열 -> 문자배열 (1차원)
            // ch : 문자 배열의 주소값 (첫 요소의 주소값)

            castle[i] = ch;

            castle[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < row; i++) { // 행
            for (int j = 0; j < col; j++) { // 각 행에서의 요소값
                if(castle[i][j] == 'X'){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        int c1 = 0; // x가 없은 행의 개수
        int c2 = 0; // x가 없는 열의 개수

        for(int i = 0; i < row; i++) {
            if(!rows[i]) c1++;
        }
        for(int i = 0; i < col; i++) {
            if(!cols[i]) c2++;
        }
        int answer = Math.max(c1, c2);


        System.out.println(answer);
    }


}
