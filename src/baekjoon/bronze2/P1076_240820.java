package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1076_240820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 색에 대한 숫자를 매칭시켰다.
        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        StringBuilder sb = new StringBuilder();

        // 주의 자바 버전 차이로 인해 백준에서는 sb.isEmpty() 를 사용할 수 없다.

        for (int i = 0; i < 3; i++) { // 3개의 색을 입력받는데
            int num = map.get(br.readLine()); // 입력받은 색에 대한 매칭된 번호를 찾아서
            if (i < 2) { // 첫번째와 두번째 입력받은 색은
                // sb 가 비어있고, black 이라는 색을 입력받았다면 sb 에 추가하지 않는다.
                if (sb.length() == 0 && num == 0) continue;
                // 그외의 조건에서는 번호를 추가한다.
                sb.append(num);
            } else { // 세번째로 입력받은 색은
                if (sb.length() == 0) break; // sb 가 비어 있다면 sb 에 추가하지 않는다.
                // 그외의 조건에서는 num 만큼 0을 추가한다.
                sb.append("0".repeat(num));
            }
        }

        if (sb.length() == 0) sb.append("0"); // 만약 sb 가 비어있다면 0을 1개추가한다.
        System.out.println(sb);
    }
}
