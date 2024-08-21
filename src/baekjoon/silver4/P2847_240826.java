package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 게임을 만든 동준이
public class P2847_240826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] intArr  = new int[n]; // 입력받는 숫자 만큼의 int 배열 생성

        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(br.readLine()); // 배열에 모든 수 저장
        }


        int reduceNum = 0; // 줄여야하는 수의 합

        /*
        * 뒤에서부터 탐색을 진행한다. -> 규칙 : 무조건 뒤에 잇는 숫자가 앞에 숫자보다 커야한다.
        * 즉 뒤에서부터 탐색해서 i번째 수가 i - 1번째 수보다 최소한 1만큼은 커야한다.
        * 중요한 점은 줄여야하는 수의 합이 최소가 되는 값을 반환해야하기 때문에
        * i번재 수가 i - 1번째 수 보다 작다면 i - 1번째 수를 i번째 수보다 1만큼 작게만 만들어준다.
        *
        * 아래 반복문의 시작 인덱스는 맨 뒤에서 두번째 위치부터 시작해서 0번 인덱스까지 반복을 돈다.
        * 그래서 i번째 수와 i + 1번째 수를 비교해서 if (i번째 수 >= i + 1번째 수) 라면 i 번째 수 = i + 1번째 수 - 1 로 설정해준다.
        * reduceNum 에는 i + 1번째 수 - 1 로 만드는 때 필요한 수를 더해준다.
        * */
        for (int i = intArr.length - 2; i >= 0; i--) {
            int low = intArr[i]; // 원래 작아야하는 값
            int high = intArr[i + 1]; // 원래 커야하는 값
            if (low >= high) {
                reduceNum += (low - high + 1); // 줄어야하는 수의 가장 최솟값 : low를 high보다 1만큼 작은 수로 만들어준다.
                intArr[i] = high - 1; // 값을 최신화한다. (다음 반복에서 사용해야하기 때문)
            }
        }

        System.out.println(reduceNum);
    }
}
