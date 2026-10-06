// JUNGOL #6095 · 정올 도서관 사서
// https://jungol.co.kr/problem/6095
// Language: Java
// Execution Time: 279 ms
// Memory: 34.5 MB

import java.io.*;
import java.util.*;

public class Main {
	// (만약 숫자가 없다면 해당 번호의 자릿수 합은 0이 된다)
    static int getDigitSum(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                sum += ch - '0';
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        String[] books = new String[N];

        for (int i = 0; i < N; i++) {
            books[i] = br.readLine();
        }

        Arrays.sort(books, (book1, book2) -> {

            // 1. 길이가 짧은 것이 더 앞으로 온다.
            if (book1.length() != book2.length()) {
                return Integer.compare(book1.length(), book2.length());
            }

            // 2. 길이가 같다면, 번호에서 각 자리의 알파벳이 아닌 숫자의 합을 구하여 더 작은 합이 앞으로 온다. 
            int sum1 = getDigitSum(book1);
            int sum2 = getDigitSum(book2);

            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            // 3. 앞의 두 조건으로 구분이 불가능한 경우 사전순으로 작은 것이 앞으로 온다. (사전순은 아스키코드를 기준으로 한다)
            return book1.compareTo(book2);
        });

        for (String book : books) {
            System.out.println(book);
        }
    }
}