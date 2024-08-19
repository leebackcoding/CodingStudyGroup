package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1672_240820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] ch = new char[][]{
                {'A', 'C', 'A', 'G'},
                {'C', 'G', 'T', 'A'},
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'G', 'T'}
        }; // 2차원 배열로 생성

        // map 을 사용해서 문자에 대한 숫자값을 지정해줬다.
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('G', 1);
        map.put('C', 2);
        map.put('T', 3);


        int n = Integer.parseInt(br.readLine()); // 입력받는 문자열의 길이를 int 로 변환

        String str = br.readLine(); // 문자열 입력받기
        char[] input = str.toCharArray(); // 문자열을 문자 배열로 만든다.


        // 뒤에서부터 문자 2개씩 쌍을 만들어서 문자 1개가 남을 때까지 반복을 해야한다.
        // 문자배열에서 마지막에서 2번째 문자에서 시작해서 0번째 문자까지 반복을 한다.
        // 예를 들어서 길이가 6인 문자배열이면 4번 인덱스부터 시작해서 0번 인덱스까지 반복한다. -> 반복 횟수 : 5번
        for (int i = input.length - 2; i >= 0; i--) {
            // i 번째와 i+1 번째 문자를 조합해서 새로운 문자를 만들어내고 그 문자를 i 번째에 저장한다.
            input[i] = ch[map.get(input[i])][map.get(input[i+1])];
            // str = str.substring(0, i) + ch[map.get(str.charAt(i))][map.get(str.charAt(i+1)];
            // 위 코드는 메모리 초과가 뜬다
            // String 객체를 계속 생성해서 만들다보니 메모리 초과가 뜰 수 있다는 점을 항상 상기하자.
        }

        // 반복을 통해 얻은 문자 배열에서 첫 인덱스의 문자가 답이 된다.
        System.out.println(input[0]);
    }

}
