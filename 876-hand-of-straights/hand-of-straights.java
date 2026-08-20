class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int key : hand) {
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        while (!mp.isEmpty()) {
            int start = mp.firstKey();

            for (int i = 0; i < groupSize; i++) {
                if (!mp.containsKey(i + start)) {
                    return false;
                }

                mp.put(i + start, mp.get(i + start) - 1);
                if (mp.get(i + start) <= 0) {
                    mp.remove(i + start);
                }
            }
        }

        return true;
    }
}