# https://www.lintcode.com/problem/web-logger/description
# 使用二分提高速度，虽然是常数级别
# 维护一个300大小的队列


class WebLogger:

    def __init__(self):
        self.queue = []

    """
    @param: timestamp: An integer
    @return: nothing
    """

    def hit(self, timestamp):
        self.queue.append(timestamp)

    """
    @param: timestamp: An integer
    @return: An integer
    """

    def get_hit_count_in_last_5_minutes(self, timestamp):
        if self.queue == []:
            return 0

        limit = timestamp - 300
        start, end = 0, len(self.queue) - 1

        while start + 1 < end:
            mid = (start + end) // 2
            if self.queue[mid] <= limit:
                start = mid
            else:
                end = mid
        if self.queue[start] > limit:
            self.queue = self.queue[start:]
        elif self.queue[end] > limit:
            self.queue = self.queue[end:]
        else:
            self.queue = []

        return len(self.queue)


if __name__ == '__main__':
    logger = WebLogger()
    logger.hit(1)
    logger.hit(1)
    cnt = logger.get_hit_count_in_last_5_minutes(3)
    print(cnt)
    logger.hit(300)
    logger.get_hit_count_in_last_5_minutes(300)
    logger.get_hit_count_in_last_5_minutes(301)
    logger.get_hit_count_in_last_5_minutes(302)
    logger.get_hit_count_in_last_5_minutes(900)
    print(logger.get_hit_count_in_last_5_minutes(900))
