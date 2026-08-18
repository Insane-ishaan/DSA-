class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int key : hand) {
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        while (!mp.isEmpty()) {
            int firstKey = mp.firstKey();

            for (int i = 0; i < groupSize; i++) {
                if (!mp.containsKey(i + firstKey)) {
                    return false;
                }

                mp.put(firstKey + i, mp.get(firstKey + i) - 1);
                if (mp.get(firstKey + i) < 1) {
                    mp.remove(firstKey + i);
                }
            }
        }

        return true;
    }
}