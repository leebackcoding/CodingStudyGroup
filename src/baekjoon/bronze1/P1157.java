package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 가장 빈도수가 높은 문자 구하기
 */
public class P1157 {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toLowerCase();

        int[] arr = new int[26];
        char[] charArray = s.toCharArray();

        for(char c : charArray) {
            arr[(int) (c - 'a')]++;
        }

        int max = arr[0];

        for(int a : arr) {
            max = Math.max(max, a);
        }
        int count = 0;
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max == arr[i]) {
                count++;
                idx = i;
            }

            if(count > 1) {
                System.out.println("?");
                return;
            }
        }

        System.out.println((char) (idx + 'A'));
    }
}
