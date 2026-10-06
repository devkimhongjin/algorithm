// SWEA #26416 · [Pro] 스마트 팜
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AZyYQt1aNvvHBIMr&solveclubId=AZt8IiBqxEDHBIN6&probBoxId=AZt8IiBqxEHHBIN6&problemBoxTitle=Pro+%EA%B8%B0%EC%B6%9C
// Language: JAVA
// Execution Time: 980 ms
// Memory: 125204 KB

import java.util.*;

class UserSolution {

    static final int B = 32;

    static int[] growthTime;

    int N;
    int bucketSize;

    Bucket[][] buckets;

    HashMap<Long, Seed> farm;

    static class Seed {
        int time;
        int row;
        int col;
        int category;
        int water;
        int lazySnapshot;

        Seed(int time, int row, int col,
             int category, int lazySnapshot) {

            this.time = time;
            this.row = row;
            this.col = col;
            this.category = category;
            this.lazySnapshot = lazySnapshot;
        }

        int getSize(int currentTime, int bucketLazy) {

            int lazyWater = bucketLazy - lazySnapshot;

            return (currentTime - time) / growthTime[category]
                    + water
                    + lazyWater;
        }
    }

    static class Bucket {
        List<Seed> seeds = new ArrayList<>();
        int lazyWater;
    }

    void init(int N, int[] mGrowthTime) {

        this.N = N;

        growthTime = mGrowthTime.clone();

        bucketSize = (N + B - 1) / B;

        buckets = new Bucket[bucketSize][bucketSize];

        for (int r = 0; r < bucketSize; r++) {
            for (int c = 0; c < bucketSize; c++) {
                buckets[r][c] = new Bucket();
            }
        }

        farm = new HashMap<>();
    }

    long getKey(int row, int col) {
        return ((long) row << 32) | (col & 0xffffffffL);
    }

    int sow(int mTime, int mRow, int mCol, int mCategory) {

        long key = getKey(mRow, mCol);

        if (farm.containsKey(key)) {
            return 0;
        }

        int br = mRow / B;
        int bc = mCol / B;

        Bucket bucket = buckets[br][bc];

        Seed seed = new Seed(
                mTime,
                mRow,
                mCol,
                mCategory,
                bucket.lazyWater
        );

        bucket.seeds.add(seed);
        farm.put(key, seed);

        return 1;
    }

    int water(int mTime, int G,
              int mRow, int mCol,
              int mHeight, int mWidth) {

        int maxRow = Math.min(N - 1, mRow + mHeight - 1);
        int maxCol = Math.min(N - 1, mCol + mWidth - 1);

        int startBR = mRow / B;
        int endBR = maxRow / B;

        int startBC = mCol / B;
        int endBC = maxCol / B;

        int count = 0;

        for (int br = startBR; br <= endBR; br++) {

            for (int bc = startBC; bc <= endBC; bc++) {

                Bucket bucket = buckets[br][bc];

                if (bucket.seeds.isEmpty()) {
                    continue;
                }

                int bucketMinRow = br * B;
                int bucketMaxRow =
                        Math.min(N - 1, bucketMinRow + B - 1);

                int bucketMinCol = bc * B;
                int bucketMaxCol =
                        Math.min(N - 1, bucketMinCol + B - 1);

                if (mRow <= bucketMinRow
                        && bucketMaxRow <= maxRow
                        && mCol <= bucketMinCol
                        && bucketMaxCol <= maxCol) {

                    bucket.lazyWater += G;

                    count += bucket.seeds.size();

                    continue;
                }

                for (Seed seed : bucket.seeds) {

                    if (seed.row >= mRow
                            && seed.row <= maxRow
                            && seed.col >= mCol
                            && seed.col <= maxCol) {

                        seed.water += G;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    int harvest(int mTime, int L,
                int mRow, int mCol,
                int mHeight, int mWidth) {

        int maxRow = Math.min(N - 1, mRow + mHeight - 1);
        int maxCol = Math.min(N - 1, mCol + mWidth - 1);

        int startBR = mRow / B;
        int endBR = maxRow / B;

        int startBC = mCol / B;
        int endBC = maxCol / B;

        List<Seed> targets = new ArrayList<>();

        for (int br = startBR; br <= endBR; br++) {

            for (int bc = startBC; bc <= endBC; bc++) {

                Bucket bucket = buckets[br][bc];

                if (bucket.seeds.isEmpty()) {
                    continue;
                }

                for (Seed seed : bucket.seeds) {

                    if (seed.row < mRow
                            || seed.row > maxRow
                            || seed.col < mCol
                            || seed.col > maxCol) {
                        continue;
                    }

                    if (seed.getSize(
                            mTime,
                            bucket.lazyWater
                    ) < L) {

                        return 0;
                    }

                    targets.add(seed);
                }
            }
        }

        for (Seed seed : targets) {

            int br = seed.row / B;
            int bc = seed.col / B;

            Bucket bucket = buckets[br][bc];

            bucket.seeds.remove(seed);

            farm.remove(
                    getKey(seed.row, seed.col)
            );
        }

        return targets.size();
    }
}