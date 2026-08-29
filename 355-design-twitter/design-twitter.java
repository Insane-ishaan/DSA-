class Twitter {
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<int[]>> tweets;
    int time = 0;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] { tweetId, time++ });
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        if (tweets.containsKey(userId)) {
            for (int temp[] : tweets.get(userId)) {
                pq.offer(temp);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (tweets.containsKey(followee)) {
                    for (int temp[] : tweets.get(followee)) {
                        pq.offer(temp);
                        if (pq.size() > 10) {
                            pq.poll();
                        }
                    }
                }
            }
        }

    
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }

        Collections.reverse(result);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            return;
        }

        following.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */