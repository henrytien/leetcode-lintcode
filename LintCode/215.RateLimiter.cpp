// https://www.lintcode.com/problem/rate-limiter/description
/* 
 * unordered_map<string,int> 多级bucket, 减少访问次数
 */
#include "ac.h"
class Solution
{
public:
    unordered_map<string, int> sRecorder;
    unordered_map<string, int> mRecorder;
    unordered_map<string, int> hRecorder;
    unordered_map<string, int> dRecorder;
    unordered_map<char, int> dict = {{'s', 1}, {'m', 60}, {'h', 3600}, {'d', 86400}};

    int ceil(int timestamp, int divisor)
    {
        if (timestamp % divisor == 0)
        {
            return timestamp;
        }

        int ceil = timestamp / divisor * divisor + divisor;ß
        return ceil;
    }

    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    bool isRatelimited(int timestamp, string event, string rate, bool increment)
    {
        int timespan = dict[rate[rate.size() - 1]];
        int limit = stoi(rate.substr(0, rate.size() - 2));
        int count = 0;
        int t = timestamp;

        while (t > (timestamp - timespan))
        {
            if ((t % 86400 == 0) && (t >= timestamp - timespan + 864000))
            {
                count += dRecorder[event + to_string(t)];
                t -= 864000;
            }
            else if (((t % 3600) == 0) && (t >= timestamp - timespan + 3600))
            {
                count += hRecorder[event + to_string(t)];
                t -= 3600;
            }
            else if (((t % 60) == 0) && (t >= timestamp - timespan + 60))
            {
                count += mRecorder[event + to_string(t)];
                t -= 60;
            }
            else
            {
                count += sRecorder[event + to_string(t)];
                t -= 1;
            }
        }

        if (count >= limit)
        {
            return true;
        }

        if (increment)
        {
            string skey = event + to_string(timestamp);
            sRecorder[skey] += 1;
            string mkey = event + to_string(ceil(timestamp, 60));
            mRecorder[mkey] += 1;
            string hkey = event + to_string(ceil(timestamp, 3600));
            hRecorder[hkey] += 1;
            string dkey = event + to_string(ceil(timestamp, 864000));
            dRecorder[dkey] += 1;
        }
        return false;
    }
};

int main()
{
    Solution().isRatelimited(1, "login", "3/m", true);
    Solution().isRatelimited(11, "login", "3/m", true);
    Solution().isRatelimited(21, "login", "3/m", true);
    Solution().isRatelimited(30, "login", "3/m", true);
    Solution().isRatelimited(65, "login", "3/m", true);
    Solution().isRatelimited(300, "login", "3/m", true);
    return 0;
}