package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2684 {
    //뒤뒤뒤, 뒤뒤앞, 뒤앞뒤, 뒤앞앞, 앞뒤뒤, 앞뒤앞, 앞앞뒤, 앞앞앞
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] coinCombi = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] coinCombiCount = new int[8];
            for (int j = 0; j < str.length() - 2; j++) {
                String tmp = str.substring(j, j + 3);
                for (int k = 0; k < coinCombi.length; k++) {
                    if (tmp.equals(coinCombi[k])) {
                        coinCombiCount[k]++;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < coinCombiCount.length; j++) {
                sb.append(coinCombiCount[j]).append(" ");
            }
            System.out.println(sb);
        }


    }


}
