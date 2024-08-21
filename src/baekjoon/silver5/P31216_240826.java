package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P31216_240826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine()); // 찾아야하는 슈퍼소수의 개수
        Set<Integer> primes = new HashSet<>(); // 소수를 오름차순으로 저장하는 set (탐색 시간을 줄이기 위해 set 사용)
        int[] supers = new int[3001]; // 인덱스를 1부터 사용해서 1 ~ 3000까지의 제약조건에 해당하는 배열 생성

        int targetNum = 1; // 1부터 시작해서 소수인지 아닌지를 판별을 할 것이다.
        int addIndex = 0; // 슈퍼소수를 찾았을 때 추가할 위치
        for (int i = 0; i < k; i++) { // k 개의 슈퍼 소수를 반복문
            int n = Integer.parseInt(br.readLine()); // 몇번째 슈퍼 소수를 찾을지 입력받고

            while (addIndex < n) { // 내가 지금까지 찾은 슈퍼소수의 개수가 찾으려는 슈퍼 소수의 순번보다 작다면 반복문 실행
                if (isPrime(targetNum)) { // targetNum 이 소수라면
                    primes.add(targetNum); // 소수를 저장하는 set 에 추가를 해주고

                    if (primes.contains(primes.size())) { // 찾은 소수의 순번이 소수라면 슈퍼 소수이다.
                        addIndex++; // 슈퍼 소수 배열에서 저장할 위치를 1 증가시키고
                        supers[addIndex] = targetNum; // 해당 위치에 찾은 슈퍼 소수를 저장한다.
                    }
                }
                targetNum++; // 소수 판별하려는 수를 1 증가시키다.
            }

            // 여기까지 오면 지금까지 찾은 슈퍼 소수의 개수가 찾으려는 슈퍼 소수의 순번보다 크거나 같은 상황이다.
            // 그래서 바로 슈퍼 소수 배열에서 꺼내서 출력하면 된다.
            sb.append(supers[n]).append("\n");
        }

        System.out.println(sb);
    }

    // 소수인지 판별하는 메소드
    private static boolean isPrime(int number) {
        if (number == 1) { // number 가 1이라면 소수가 아니다.
            return false;
        }

        // i는 2부터 시작해서 number 의 제곱근까지 1씩 증가하는 for 문
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) { // i 가 number 의 약수라면
                return false; // 소수가 아니다. (false 리턴)
            }
        }

        // 여기까지 온거면 약수를 찾지 못한 것이므로 해당 number 는 소수이다. (true 리턴)
        return true;
    }
}
