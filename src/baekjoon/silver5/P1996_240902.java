package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1996_240902 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        int[][] ziro = new int[N][N];

        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) { // 행번호
            for (int j = 0; j < N; j++) { // 열번호
                if (!map[i][j].equals(".")) { //지뢰라면
                    sb.append("*"); // 별대입
                    continue; // 다음꺼 검사
                } else { // 지뢰가 아닐 때
                    for (int[] a : adj) { // 인접 검사
                        int x = a[0] + j;
                        int y = a[1] + i;
                        if(isIn(x, y, N) && !map[y][x].equals(".")) {
                            ziro[i][j] += Integer.parseInt(map[y][x]);
                        }
                    }
                }

                if (ziro[i][j] >= 10) {
                    sb.append("M");
                } else {
                    sb.append(ziro[i][j]);
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        String[][] map = new String[N][N]; // 처음 입력 배열
//        int[][] ziro = new int[N][N]; // 근처 지뢰를 넣어주기
//        String[][] answers = new String[N][N]; // 정답 배열
//
//        // 검사해야할 인접 좌표
//        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
//
//        for (int i = 0; i < N; i++) {
//            map[i] = br.readLine().split("");
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < N; i++) { // 행 번호
//            for (int j = 0; j < N; j++) { // 열 번호
//                if (!map[i][j].equals(".")) { // 지뢰라면
//                    int num = Integer.parseInt(map[i][j]); // 지뢰가 몇개인지 int로 변환
//                    for (int[] a : adj) { //{0, 1}, {0, -1}
//                        int x = a[0] + j;
//                        int y = a[1] + i;
//                        if(isIn(x, y, N) && map[y][x].equals(".")) {
//                            ziro[y][x] += num;
//                        }
//                    }
//
//                    answers[i][j] = "*";
//                }
//            }
//        }
//
//        for (int i = 0; i < N; i++) { // 행번호
//            for (int j = 0; j < N; j++) { // 열번호
//                if (answers[i][j] == null) { // 지뢰가 없는 자리
//                    if (ziro[i][j] >= 10) { // 지뢰가 10개 이상이라면
//                        answers[i][j] = "M"; // M
//                    } else { // 지뢰가 10개 미만
//                        answers[i][j] = String.valueOf(ziro[i][j]);
//                    }
//                }
//                sb.append(answers[i][j]);
//            }
//            sb.append("\n"); // 줄바꿈, 개행
//        }
//
//        System.out.println(sb);
//    }

    // 배열 안에 존재하는지 판단하는 메서드
    private static boolean isIn(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
