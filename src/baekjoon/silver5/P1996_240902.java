package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1996_240902 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        String[][] map = new String[N][N];
//        int[][] ziro = new int[N][N];
//
//        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
//
//        for (int i = 0; i < N; i++) {
//            map[i] = br.readLine().split("");
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (!map[i][j].equals(".")) {
//                    sb.append("*");
//                    continue;
//                } else {
//                    for (int[] a : adj) {
//                        int x = a[0] + j;
//                        int y = a[1] + i;
//                        if(isIn(x, y, N) && !map[y][x].equals(".")) {
//                            ziro[i][j] += Integer.parseInt(map[y][x]);
//                        }
//                    }
//                }
//
//                if (ziro[i][j] >= 10) {
//                    sb.append("M");
//                } else {
//                    sb.append(ziro[i][j]);
//                }
//
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        int[][] ziro = new int[N][N];
        String[][] answers = new String[N][N];

        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j].equals(".")) {
                    int num = Integer.parseInt(map[i][j]);
                    for (int[] a : adj) {
                        int x = a[0] + j;
                        int y = a[1] + i;
                        if(isIn(x, y, N) && map[y][x].equals(".")) {
                            ziro[y][x] += num;
                        }
                    }

                    answers[i][j] = "*";
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (answers[i][j] == null) {
                    if (ziro[i][j] >= 10) {
                        answers[i][j] = "M";
                    } else {
                        answers[i][j] = String.valueOf(ziro[i][j]);
                    }
                }
                sb.append(answers[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isIn(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
