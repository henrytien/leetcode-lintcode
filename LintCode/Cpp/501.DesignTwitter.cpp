// https://www.lintcode.com/problem/design-twitter/description

/**
 * Definition of Tweet:
 * class Tweet {
 * public:
 *     int id;
 *     int user_id;
 *     String text;
 *     static Tweet create(int user_id, string tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
 
 class Node{
public:
    int order;
    Tweet tweet;
    Node(int o,Tweet t) {
        order = o,tweet = t;
    }

    bool operator<(const Node &o) const
    {
        return order > o.order;
    }
};

class MiniTwitter
{
  private:
    map<int, set<int>> friends;
    map<int, vector<Node>> users_tweets;
    int order;

  public:
    MiniTwitter()
    {
        order = 0;
        friends.clear();
        users_tweets.clear();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    Tweet postTweet(int user_id, string tweet_text)
    {
        Tweet tweet = Tweet::create(user_id, tweet_text);
        if (users_tweets.find(user_id) == users_tweets.end())
            users_tweets[user_id] = vector<Node>();
        order += 1;
        users_tweets[user_id].push_back(Node(order, tweet));
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    vector<Tweet> getNewsFeed(int user_id) {
        vector<Node> res;
        if (users_tweets.find(user_id) != users_tweets.end()) {
            res = getTen(users_tweets[user_id]);
        }
        
       if (friends.find(user_id) != friends.end()) {
           for (set<int>::iterator iter = friends[user_id].begin(); iter != friends[user_id].end(); ++iter) {
                int user = *iter;
                if (users_tweets.find(user) != users_tweets.end()) {
                    vector<Node> temp = getTen(users_tweets[user]);
                     copy(temp.begin(),temp.end(),back_inserter(res));
                }
            }
        }
        sort(res.begin(), res.end());
        vector<Tweet> rt;
        for (int i = 0; i < res.size(); ++i)
        {
            if (i >= 10)
                break;
            rt.push_back(res[i].tweet);
        }
        return rt;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    vector<Tweet> getTimeline(int user_id)
    {
        vector<Node> tmp;
        if (users_tweets.find(user_id) != users_tweets.end())
            tmp = getTen(users_tweets[user_id]);
        sort(tmp.begin(), tmp.end());
        vector<Tweet> rt;
        for (int i = 0; i < tmp.size(); ++i)
        {
            if (i >= 10)
                break;
            rt.push_back(tmp[i].tweet);
        }
        return rt;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    void follow(int from_user_id, int to_user_id)
    {
        if (friends.find(from_user_id) == friends.end())
            friends[from_user_id] = set<int>();
        friends[from_user_id].insert(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    void unfollow(int from_user_id, int to_user_id)
    {
        if (friends.find(from_user_id) == friends.end())
            return;
        friends[from_user_id].erase(to_user_id);
            
    }

    vector<Node> getTen(vector<Node> &tmp)
    {
        int cnt = 0;
        vector<Node> v1;
        int n = tmp.size();
        for (int i = n - 1; i >= 0; --i)
        {
            cnt++;
            v1.push_back(tmp[i]);
            if (cnt >= 10)
                break;
        }
        return v1;
    }
};