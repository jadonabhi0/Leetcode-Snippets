class Twitter {

    class Tweet {
        Integer tweetId;
        Integer ts; // timestamp

        public Tweet(Integer tweetId, Integer ts) {
            this.tweetId = tweetId;
            this.ts = ts;
        }
    }

    class User {
        int userId;
        Set<Integer> followees; // store followee IDs
        List<Tweet> tweets;

        public User(int userId) {
            this.userId = userId;
            this.followees = new HashSet<>();
            this.tweets = new LinkedList<>();
        }

        public void addTweet(Integer tweetId, int ts) {
            this.tweets.add(0, new Tweet(tweetId, ts));
        }

        public void addFollowee(Integer followeeId) {
            this.followees.add(followeeId);
        }

        public void removeFollowee(Integer followeeId) {
            this.followees.remove(followeeId);
        }
    }

    HashMap<Integer, User> umap;
    int globalTime; // shared timestamp

    public Twitter() {
        umap = new HashMap<>();
        globalTime = 0;
    }

    public void postTweet(int userId, int tweetId) {
        umap.putIfAbsent(userId, new User(userId));
        globalTime++;
        umap.get(userId).addTweet(tweetId, globalTime);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!umap.containsKey(userId)) return new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.ts, t1.ts));

        User user = umap.get(userId);

        // add own tweets
        pq.addAll(user.tweets);

        // add followees' tweets
        for (Integer fid : user.followees) {
            if (umap.containsKey(fid)) {
                pq.addAll(umap.get(fid).tweets);
            }
        }

        List<Integer> ans = new LinkedList<>();
        int cnt = 0;
        while (!pq.isEmpty() && cnt < 10) {
            ans.add(pq.poll().tweetId);
            cnt++;
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot follow self
        umap.putIfAbsent(followerId, new User(followerId));
        umap.putIfAbsent(followeeId, new User(followeeId));
        umap.get(followerId).addFollowee(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!umap.containsKey(followerId) || followerId == followeeId) return;
        umap.get(followerId).removeFollowee(followeeId);
    }
}
