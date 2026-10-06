// PROGRAMMERS #60062 · 외벽 점검
// https://school.programmers.co.kr/learn/courses/30/lessons/60062
// Language: java

class Solution {

    static int ans = -1;

    // 원형 외벽의 취약 지점을 일자로 펼친 배열
    static int[] spreadWeak;

    // 취약 지점 개수
    static int weakCnt;

    public static int solution(int n, int[] weak, int[] dist) {

        weakCnt = weak.length;

        // 원형 구조를 일자로 탐색할 수 있도록 취약 지점을 확장
        spreadWeak = spreadPoint(n, weak);

        /*
         * 친구를 1명 사용하는 경우부터 차례대로 확인
         *
         * 1명으로 가능하면 1이 최소값
         * 불가능하면 2명, 3명 ... 순서로 확인한다.
         */
        for (int i = 1; i <= dist.length; i++) {
            perm(
                0,
                i,
                dist,
                new boolean[dist.length],
                new int[i]
            );
        }

        return ans;
    }

    /*
     * 친구들의 이동 가능 거리를 순열로 생성
     *
     * 예)
     * dist = {1, 2, 3}
     * cnt = 2
     *
     * {1, 2}
     * {1, 3}
     * {2, 1}
     * {2, 3}
     * {3, 1}
     * {3, 2}
     *
     * 친구마다 이동 가능한 거리가 다르기 때문에
     * 사용하는 순서에 따라 결과가 달라질 수 있다.
     */
    private static void perm(
        int depth,
        int cnt,
        int[] dist,
        boolean[] visit,
        int[] res
    ) {

        // 이미 최소 친구 수를 찾았다면 더 탐색할 필요 없음
        if (ans != -1) {
            return;
        }

        // 사용할 친구들의 순서가 완성된 경우
        if (depth == cnt) {
            check(res);
            return;
        }

        for (int i = 0; i < dist.length; i++) {

            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            res[depth] = dist[i];

            perm(depth + 1, cnt, dist, visit, res);

            visit[i] = false;
        }
    }

    /*
     * 현재 친구 배치(res)로
     * 모든 취약 지점을 점검할 수 있는지 확인
     */
    private static void check(int[] res) {

        /*
         * 원형 외벽이므로
         * 각 취약 지점을 시작점으로 잡아 모두 확인한다.
         */
        outer:
        for (int i = 0; i < weakCnt; i++) {

            // 현재 친구가 점검을 시작한 취약 지점
            int start = i;

            // 현재 투입된 친구 번호
            int friend = 0;

            /*
             * 시작 지점부터 취약 지점 개수만큼 확인
             *
             * spreadWeak 배열을 사용하기 때문에
             * 원형을 일자로 탐색할 수 있다.
             */
            for (int j = i; j < i + weakCnt; j++) {

                /*
                 * 현재 친구가 해당 취약 지점까지 도달할 수 없다면
                 * 다음 친구를 투입한다.
                 */
                if (spreadWeak[j] - spreadWeak[start] > res[friend]) {
                    start = j;
                    friend++;
                }

                /*
                 * 모든 친구를 사용했는데도
                 * 아직 취약 지점이 남았다면
                 * 현재 시작점에서는 실패
                 */
                if (friend == res.length) {
                    continue outer;
                }
            }

            /*
             * 모든 취약 지점을 점검했다면
             * 현재 친구 수가 최소값
             *
             * solution에서 친구 수를
             * 1명부터 증가시키며 확인하고 있기 때문
             */
            ans = res.length;
            return;
        }
    }

    /*
     * 원형으로 존재하는 취약 지점을
     * 일자로 탐색할 수 있도록 배열을 확장
     *
     * 예)
     * n = 12
     * weak = {1, 5, 6, 10}
     *
     * spread =
     * {1, 5, 6, 10, 13, 17, 18}
     *
     * 13 = 1 + 12
     * 17 = 5 + 12
     * 18 = 6 + 12
     *
     * 마지막 원소(10 + 12)는
     * 탐색 과정에서 필요하지 않아 추가하지 않는다.
     */
    private static int[] spreadPoint(int n, int[] weak) {

        int[] spread = new int[weak.length * 2 - 1];

        // 기존 취약 지점 저장
        for (int i = 0; i < weak.length; i++) {
            spread[i] = weak[i];
        }

        // 한 바퀴 뒤의 취약 지점을 이어서 저장
        for (int i = 0; i < weak.length - 1; i++) {
            spread[i + weak.length] = weak[i] + n;
        }

        return spread;
    }
}