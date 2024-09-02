package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1531_240902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 모자이크 종이의 수
        int M = Integer.parseInt(st.nextToken()); // 안보이는 기준 종이 수 (M 개 초과의 종이로 가려야 안보임)
        int[][] picture = new int[101][101]; // 그림은 100 x 100 의 크기이다. 인덱스 1부터 시작하려고 101 x 101로 만들었다.
        int[][] mojaik = new int[2][2]; // 하나의 종이에서 왼쪽 하단의 좌표와 오른쪽 상단의 좌표를 담는 배열
        int answer = 0; // 가려지는 좌표의 개수

        for (int i = 0; i < N; i++) { // 종이의 개수만큼 반복
            st = new StringTokenizer(br.readLine());

            // 하나의 종이의 왼쪽 상단의 좌표와 오른쪽 상단의 좌표를 입력받는다.
            mojaik[0][0] = Integer.parseInt(st.nextToken()); // 왼쪽 하단의 y좌표
            mojaik[0][1] = Integer.parseInt(st.nextToken()); // 왼쪽 하단의 x좌표
            mojaik[1][0] = Integer.parseInt(st.nextToken()); // 오른쪽 상단의 y좌표
            mojaik[1][1] = Integer.parseInt(st.nextToken()); // 오른쪽 상단의 x 좌표

            for (int j = mojaik[0][1]; j <= mojaik[1][1]; j++) {
                for (int k = mojaik[0][0]; k <= mojaik[1][0]; k++) {
                    picture[j][k]++; // 해당 종이의 범위에 있는 좌표를 1증가시킴
                }
            }
        }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] > M) { // 해당 좌표의 값이 M을 넘는다면
                    answer++;  // 안보이는 좌표의 개수를 증가시킨다.
                }
            }
        }

        System.out.println(answer);
    }
}
