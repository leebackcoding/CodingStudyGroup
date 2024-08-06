package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1236 {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] castle = new char[row][col];
        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];

        for(int i = 0; i < row; i++) {
            castle[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(castle[i][j] == 'X'){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        int c1 = 0;
        int c2 = 0;

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
