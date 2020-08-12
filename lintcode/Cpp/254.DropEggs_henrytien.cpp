// https://www.lintcode.com/problem/drop-eggs/description
class Solution {
public:
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    int dropEggs(int n) {
        // write your code here
        long long ans = 0;
        int x = 0;
        while (ans < n) {
            x += 1;
            ans += x;
        }
       return x; 
    }
};