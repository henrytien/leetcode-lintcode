// https://www.lintcode.com/problem/the-longest-common-prefix-ii/description
class Solution {
public:
    /**
     * @param dic: the n strings
     * @param target: the target string
     * @return: The ans
     */
    int the_longest_common_prefix(vector<string> &dic, string &target) {
        // write your code here
        int ans = 0;
        for(string it : dic) {
            int cnt = 0;
            for(int i = 0; i < target.size(); i++) {
                if(i > it.size() - 1 || target[i] != it[i]) {
                    break;
                }
                cnt++;
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};