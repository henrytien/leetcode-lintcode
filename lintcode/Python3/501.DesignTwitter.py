# https://www.lintcode.com/problem/design-twitter/description
# K路归并算法，优先队列，特别是getNewsFeed,需要从关注列表去维护一个hash，使用
# 一个变量time去记录发帖的时间
'''
Definition of Tweet:
class Tweet:
    @classmethod
    def create(cls, user_id, tweet_text):
         # This will create a new tweet object,
         # and auto fill id
'''
from collections import defaultdict
from heapq import heappop, heappush


class MiniTwitter:

    def __init__(self):
        # tweet dict
        self.map = defaultdict(list)
        # follower
        self.followers = defaultdict(list)
        self.time = 0

    """
    @param: user_id: An integer
    @param: tweet_text: a string
    @return: a tweet
    """

    def postTweet(self, user_id, tweet_text):
        newTweet = Tweet.create(user_id, tweet_text)
        self.map[user_id].append((self.time, newTweet))
        self.time += 1
        return newTweet

    """
    @param: user_id: An integer
    @return: a list of 10 new feeds recently and sort by timeline
    """

    def getNewsFeed(self, user_id):
        heap = []
        for follow in self.followers[user_id]:
            for time, tweet in self.map[follow]:
                heappush(heap, (-time, tweet))
        for time, tweet in self.map[user_id]:
            heappush(heap, (-time, tweet))
        n = len(heap)
        result = []
        i = 0
        while i < 10 and i < n:
            time, tweet = heappop(heap)
            result.append(tweet)
            i += 1

        return result

    """
    @param: user_id: An integer
    @return: a list of 10 new posts recently and sort by timeline
    """

    def getTimeline(self, user_id):
        heap = []
        for time, tweet in self.map[user_id]:
            heappush(heap, (-time, tweet))
        result = []
        i = 0
        n = len(heap)
        while i < 10 and i < n:
            time, tweet = heappop(heap)
            result.append(tweet)
            i += 1
        return result

    """
    @param: from_user_id: An integer
    @param: to_user_id: An integer
    @return: nothing
    """

    def follow(self, from_user_id, to_user_id):
        if to_user_id not in self.followers[from_user_id]:
            self.followers[from_user_id].append(to_user_id)

    """
    @param: from_user_id: An integer
    @param: to_user_id: An integer
    @return: nothing
    """

    def unfollow(self, from_user_id, to_user_id):
        if to_user_id in self.followers[from_user_id]:
            self.followers[from_user_id].remove(to_user_id)
