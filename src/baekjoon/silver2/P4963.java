package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P4963 {
    static class Node {
        int x;
        int y;

        Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] move = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {0, 1}, {0, -1}};
    private static int w;
    private static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 열의 개수
            h = Integer.parseInt(st.nextToken()); // 행의 개수

            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        dfs1(i, j, map, visited);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int startY, int startX, int[][] map, boolean[][] visited) {
        Stack<Node> stack = new Stack<>();

        stack.push(new Node(startY, startX));

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            int y = pop.y;
            int x = pop.x;

            if (visited[y][x]) continue;
            visited[y][x] = true;

            for (int[] m : move) {
                int nextY = pop.y + m[0];
                int nextX = pop.x + m[1];

                if (isIn(nextY, nextX) && map[nextY][nextX] == 1) {
                    stack.push(new Node(nextY, nextX));
                }
            }
        }
    }

    private static void dfs1(int startY, int startX, int[][] map, boolean[][] visited) {

        if (visited[startY][startX]) return;

        visited[startY][startX] = true;
        for(int[] m : move) {
            int nextY = startY + m[0];
            int nextX = startX + m[1];

            if (isIn(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                dfs1(nextY, nextX, map, visited);
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return y < h && y >= 0 && x < w && x >= 0;
    }
}
