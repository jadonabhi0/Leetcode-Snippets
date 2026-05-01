import java.util.*;

class Tweet {
    int time;
    int tweetId;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class User {
    int userId;
    Set<Integer> followee;
    List<Tweet> tweets;

    User(int id) {
        this.userId = id;
        this.followee = new HashSet<>();
        this.tweets = new ArrayList<>();
        followee.add(id); // follow self
    }

    public void addPost(int tweetId, int time) {
        tweets.add(new Tweet(tweetId, time));
    }

    public void follow(int followId) {
        followee.add(followId);
    }

    public void unFollow(int followId) {
        followee.remove(followId);
    }
}

class Twitter {

    int time = 0;
    Map<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }

    private User addUser(int userId) {
        users.putIfAbsent(userId, new User(userId));
        return users.get(userId);
    }

    private User getUser(int userId) {
        return users.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User u = addUser(userId);
        u.addPost(tweetId, time++);
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        if (user == null) return new ArrayList<>();

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int followeeId : user.followee) {
            User fUser = getUser(followeeId);
            if (fUser != null) {
                pq.addAll(fUser.tweets);
            }
        }

        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            feed.add(pq.poll().tweetId);
            count++;
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        User u = addUser(followerId);
        addUser(followeeId);
        u.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User u = getUser(followerId);
        if (u != null && followerId != followeeId) {
            u.unFollow(followeeId);
        }
    }
}