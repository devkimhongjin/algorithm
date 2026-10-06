// PROGRAMMERS #389481 · 봉인된 주문
// https://school.programmers.co.kr/learn/courses/30/lessons/389481
// Language: java

import java.util.*;

class Solution {
    static final String ALPHABET = "0abcdefghijklmnopqrstuvwxyz";
    static final int BASE = ALPHABET.length()-1;

    static String longToSpell(long n) {
        if (n <= 0) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int remainder = (int) (n % BASE);
            n /= BASE;

            if (remainder == 0) {
                remainder = BASE;
                n--;
            }

            result.append(ALPHABET.charAt(remainder));
        }

        return result.reverse().toString();
    }

    static long spellToLong(String s) {
        long result = 0;

        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a' + 1;
            result = result * BASE + cur;
        }

        return result;
    }
    
    public String solution(long n, String[] bans) {
        long[] banned = new long[bans.length];

        for (int i = 0; i < bans.length; i++) {
            banned[i] = spellToLong(bans[i]);
        }

        Arrays.sort(banned);

        for (long num : banned) {
            if (num > n) {
                break;
            }

            n++;
        }

        return longToSpell(n);
    }
}