package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝궁 {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights); // 오름차순으로 정렬
        Map<Double, Integer> map = new HashMap<>(); // 빠른 검색을 위한 HashMap 사용

        for (int w : weights) { // 각 몸무게에 대해서
            // 현재 몸무게가 지금까지의 몸무게 중에서 가장 무거운 무게이다.
            double w1_1 = w * 1.0;  // 현재 몸무게랑 같은 무게
            double w1_2 = w * 0.5; // 현재 몸무게의 절반
            double w2_3 = w * (2.0) / (3.0); // 현재 몸무게의 (2/3)
            double w3_4 = w * (3.0) / (4.0); // 현재 몸무게의 (3/4)

            // 해당 몸무게가 map 에 포함되어 있다면 포함된 수만큼 answer 에 더한다.
            if(map.containsKey(w1_1)) answer += map.get(w1_1);
            if(map.containsKey(w1_2)) answer += map.get(w1_2);
            if(map.containsKey(w2_3)) answer += map.get(w2_3);
            if(map.containsKey(w3_4)) answer += map.get(w3_4);

            // 해당 원래 몸무게를 map 에 추가해준다.
            map.put(w1_1, map.getOrDefault(w1_1, 0) + 1);
        }
        return answer;
    }
}
