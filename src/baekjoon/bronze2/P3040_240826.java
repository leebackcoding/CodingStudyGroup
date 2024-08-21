package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3040_240826 {
//    // 첫번째 방법
//    private static int[] answer; // 합이 100이 되는 7개의 수를 담는 정답 배열
//    private static boolean flag = false; // 정답 조합을 찾으면 true, 아니면 false 로 설정함
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] numbers = new int[9]; // 입력 받는 9개의 숫자를 담는 배열
//
//        for (int i = 0; i < 9; i++) {
//            // 9개의 수를 배열에 모두 저장해준다.
//            numbers[i] = Integer.parseInt(br.readLine());
//        }
//
//        // combi 라는 메소드를 호출해서 합계 100을 만드는 숫자 7개의 조합을 구한다.
//        combi(new int[7], numbers, 0, 0, 0);
//
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]); // 정답 조합의 숫자들을 차례로 출력한다.
//        }
//
//    }
//
//    // 숫자 합 100을 만드는 7개의 숫자 조합을 구하는 dfs 메소드
//    private static void combi(int[] combis ,int[] numbers, int depth, int sum, int startIdx) {
//        /*
//        * 매개 변수 설명
//        * int[] combis : 재귀함수를 돌면서 현재까지의 숫자 조합을 담는 배열
//        * int[] numbers : 입력받은 9개의 숫자 배열
//        * int depth : 깊이 우선 탐색에서 깊이를 담당하는 변수,
//        *             이 변수는 재귀함수에 7개의 숫자를 찾는 과정에서 지금까지 몇개의 숫자를 찾았는지를 알 수 있게 하는 변수
//        * int startIdx : 지금까지 찾은 숫자들 중복해서 선택하지 않도록 하는 인덱스 변수
//        * 예를 들어서 현재 2번째 인덱스의 숫자를 선택했다면 다음 선택할 숫자는 3번째 인덱스 이후부터 고를도록 startIdx 를 설정해준다.
//        * */
//
//
//        if (depth == 7) {  // depth 가 7이 되었다는 것은 7개의 숫자를 모두 선택했다는 것을 의미한다.
//            if (sum == 100){ // 7개의 숫자 조합의 합이 100이라면
//                answer = new int[7]; // 정답 조합을 배열 공간을 7개로 생성해주고
//                for (int i = 0; i < 7; i++) {
//                    answer[i] = combis[i]; // 각 요소를 answer 에 저장해준다.
//                    // 여기서 중요한 점은 주소값을 answer 에 넘겨주지 않았다.
//                    // 그 이유는 combis 는 계속 변화하는 배열이라서 값 자체를 answer 에 저장해줌으로써
//                    // answer 배열의 불변성을 챙겨주는 것이다.
//                }
//
//                flag = true; // 합계가 100인 조합을 찾았으므로 flag 를 true 로 변경해준다.
//            }
//
//            return; // 7개의 숫자 조합을 찾았다면 더 이상 깊이 탐색을 진행하지 않는다.
//        }
//
//        // 숫자를 고르기 위한 반복문 (현재의 깊이에서는 이전에 골랐던 숫자의 인덱스 이후부터 고를 수 있다. -> 중복 선택을 방지)
//        for (int i = startIdx; i < 9; i++) {
//            if (!flag) { // 정답 조합이 아직 만들어지지 않았다면
//                combis[depth] = numbers[i]; // 지금 고른 숫자를 depth 인덱스에 저장한다.
//
//                // 현재 고른 숫자를 기준으로 깊이 탐색을 진행한다.
//                /*
//                * 현재 숫자를 담은 배열 combis
//                * 다음 깊이 탐색의 깊이를 담는 depth + 1
//                * 현재까지의 합계를 담는 sum + numbers[i]
//                * 다음 탐색에서 탐색 시작 위치 i + 1
//                * 위 변수들을 매개변수로 다음 재귀 함수에 넘겨준다.
//                * */
//                combi(combis, numbers, depth + 1, sum + numbers[i], i + 1);
//
//                // 깊이 탐색을 하고 나서는 다음 깊이 탐색을 위해 combis 를 처음 상태로 되돌려 놓는다.
//                combis[depth] = 0;
//            } else { // flag 가 true 라는 것은 정답 조합을 찾았다는 의미이므로
//                return; // 더 이상의 탐색을 진행하지 않는다.
//            }
//        }
//
//    }



//    // 두번째 방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] arr = new int[9]; // 입력받는 숫자를 담는 배열
//
//        int target = -100; // 빼는 2개의 숫자의 합이 target 이 되는 숫자 조합을 찾는다.
//
//        for (int i = 0; i < 9; i++) {
//            arr[i] = Integer.parseInt(br.readLine()); // 9개의 숫자를 입력받아서 arr 배열에 저장
//            target += arr[i]; // 9개의 숫자를 target 에 더한다.
//        }
//
//
//
//        boolean[] idx = new boolean[9]; // 뺄 숫자는 true 로 설정 할 것이다.
//        firstFor:
//        for (int i = 0; i < 9; i++) { // 처음으로 고른 숫자
//            for (int j = i + 1; j < 9; j++) { // 두번째로 고르는 숫자
//                // 2개의 숫자로 이루어진 조합의 합이 target 이라면
//                if (arr[i] + arr[j] == target) {
//                    // 2 개의 숫자의 인덱스에 해당하는 idx 배열의 값을 true 로 변경
//                    idx[i] = true;
//                    idx[j] = true;
//                    break firstFor; // 조합을 찾았으니 더 이상의 탐색은 의미가 없어서 break 한다.
//                }
//            }
//        }
//
//        for (int i = 0; i < 9; i++) {
//            // 9개의 숫자에서 빼야할 숫자를 제외하고 출력을 한다.
//            if (!idx[i]) System.out.println(arr[i]);
//        }
//
//    }

    // 세번째 방법
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9]; // 입력받는 숫자 9개를 저장하는 배열
        int[] sortedArr = new int[9]; // 오름차순을 하기 위해 추가로 생성한 배열
        int target = -100; // 빼야할 2개의 숫자 조합의 합계를 찾기 위한 target 변수 설정

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 9개의 숫자를 arr 배열에 저장
            sortedArr[i] = arr[i]; // 오름 차순 정렬을 하기 위해서 sortedArr 에도 똑같이 저장한다.
            target += arr[i]; // 9개의 숫자를 target 에 더해준다.
        }

        Arrays.sort(sortedArr); // sortedArr 를 오름차순 정렬을 한다. (투 포인터를 위한 준비 과정)

        int start = 0; // 첫번째 포인터 : 맨 앞 인덱스에서 시작
        int end = 8; // 두번째 포인터 : 맨 뒤 인덱스에서 시작
        int sum = 0; // 두 포인터에 해당하는 값의 합을 sum 에 담을 예정
        while (sortedArr[start] + sortedArr[end] != target) { // 두 포인터의 값의 합이 target 과 다르면 반복문 수행
            sum = sortedArr[start] + sortedArr[end]; // 두 포인터의 값의 합을 sum 에 저장

            if (sum > target) { // 뺄 두 수의 합이 target 보다 크면
                end--; // end 포인터를 낮춘다. (이 말은 즉 더 작은 수를 선택하는 것이다.)
            } else if (sum < target) { // 뺄 두 수의 합이 target 보다 작다면
                start++; // start 포인터를 높인다. (이 말은 더 큰 수를 선택하는 것이다.)
            }

        }

        // 여기까지 오면 두 수의 합이 target 이 되는 두 수를 구했다는 것이다.
        // 그 인덱스는 start 와 end 에 해당한다.

        for (int n : arr) { // 처음 입력받은 배열 arr 을 반복하면서
            if (n != sortedArr[start] && n != sortedArr[end]) { // 해당 요소의 값이 빼야할 수와 다르다면
                System.out.println(n); // 그 수는 출력을 한다.
            }
        }
    }
}
