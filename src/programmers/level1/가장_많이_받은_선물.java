package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장_많이_받은_선물 {

    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {

        Map<String, Integer> fNum = new HashMap<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();

        for(int i = 0; i < friends.length; i++) {
            fNum.put(friends[i], i);
            map.put(friends[i], new HashMap<>());
        }

        int[] giftScore = new int[friends.length];

        for(String g : gifts) {
            StringTokenizer st = new StringTokenizer(g);
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            // p1이 p2에게 선물을 준다.
            map.get(p1).put(p2, map.get(p1).getOrDefault(p2, 0) + 1);

            giftScore[fNum.get(p1)]++;
            giftScore[fNum.get(p2)]--;
        }
        int[] arr = new int[friends.length];

        for(int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {
                Integer p1Top2 = map.get(friends[i]).getOrDefault(friends[j], 0);
                Integer p2Top1 = map.get(friends[j]).getOrDefault(friends[i], 0);
                if ((p1Top2 == null && p2Top1 == null) || (p1Top2 == p2Top1)) {
                    int p1 = giftScore[i];
                    int p2 = giftScore[j];
                    if (p1 > p2) {
                        arr[i]++;
                    } else if (p1 < p2) {
                        arr[j]++;
                    }
                } else {
                    if (p1Top2 > p2Top1) {
                        arr[i]++;
                    } else {
                        arr[j]++;
                    }
                }
            }
        }
        int max = 0;

        for(int i : arr) {
            max = max < i ? i : max;
        }

        return max;
    }
}
