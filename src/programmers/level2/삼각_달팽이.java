package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 삼각_달팽이 {

    public static void main(String[] args) {
        int[] res = solution(5);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

    public static boolean[][] visited;
    public static int[] solution(int n) {
        int[][] arr = new int[n][n];
        visited = new boolean[n][n];
        // 0 : 아래, 1 : 오른쪽, 2 : 위로 왼쪽
        int dir = 0;
        int firstY = 0;
        int firstX = 0;
        int nextY = 0;
        int nextX = 0;
        int startNum = 1;
        int end = n * (n + 1) / 2;
        int chance = 0;
        while (chance < end) {
            chance++;
            arr[firstY][firstX] = startNum++;
            visited[firstY][firstX] = true;
            if (dir == 0) {
                nextY++;
            } else if (dir == 1) {
                nextX++;
            } else {
                nextY--;
                nextX--;
            }
            int afterDir = isChangeDir(nextY, nextX, dir, n);
            if (afterDir == dir) {
                firstY = nextY;
                firstX = nextX;
            } else {
                dir = afterDir;
                if (dir == 0) {
                    firstY++;
                } else if (dir == 1) {
                    firstX++;
                } else {
                    firstY--;
                    firstX--;
                }
            }
            nextY = firstY;
            nextX = firstX;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                list.add(arr[i][j]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 0 : 아래, 1 : 오른쪽, 2 : 위로 왼쪽
    public static int isChangeDir(int y, int x, int dir, int n) {
        if ((y == n && dir == 0) || (x == n && dir == 1) || visited[y][x]) {
            dir++;
        }
        return dir % 3;
    }
}
