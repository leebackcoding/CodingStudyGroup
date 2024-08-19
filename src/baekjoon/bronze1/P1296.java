package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1296 {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String yondu = br.readLine();
        int num = Integer.parseInt(br.readLine());
        String[] names = new String[num];
        Map<Character, Integer> yonduChar = new HashMap<>();

        for(char c : yondu.toCharArray()) {
            yonduChar.put(c, yonduChar.getOrDefault(c, 0) + 1);
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < num; i++) {
            names[i] = br.readLine();
            Map<Character, Integer> tmp = new HashMap<>();

            for(char c : names[i].toCharArray()) {
                if(yonduChar.containsKey(c)) {
                    tmp.put(c, tmp.getOrDefault(c, 0) + 1);
                }
            }
            for(char c : yonduChar.keySet()) {
                tmp.put(c, tmp.getOrDefault(c, 0) + yonduChar.get(c));
            }

            int[] arr = new int[tmp.size()];
            int idx = 0;
            for(char c : tmp.keySet()) {
                arr[idx++] = tmp.get(c);
            }
            int sum = 1;
            for(int k = 0; k < arr.length; k++) {
                for (int j = k + 1; j < arr.length; j++) {
                    sum *= (arr[i] + arr[j]);
                }
            }
            map.put(names[i], sum % 100);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> o1.compareTo(o2));
        int max = 0;
        String answer = "";
        for(String n : list) {
            if (max < map.get(n)) answer = n;
        }

        for(String n : list) {
            System.out.println(n + " : " + map.get(n));
        }

        System.out.println(answer);

    }

}
