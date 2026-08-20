class El implements Comparable<El> {
    int val;

    public El(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(El e2) {
        return e2.val - this.val;
    }
}

class Solution {
    int time = 0;

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<El> pq = new PriorityQueue<>();
        int freqChars[] = new int[26];
        for (char task : tasks) {
            freqChars[task - 'A']++;
        }

        for (int task : freqChars) {
            if (task > 0) {
                pq.add(new El(task));
            }
        }

        while ((!pq.isEmpty())) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 1; i <= n + 1; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll().val;
                    freq--;
                    temp.add(freq);
                }
            }

            for (int f : temp) {
                if (f > 0) {
                    pq.offer(new El(f));
                }
            }

            if (pq.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;
            }

        }

        return time;
    }
}