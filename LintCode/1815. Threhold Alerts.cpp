// https://www.lintcode.com/problem/threhold-alerts/description?_from=contest&&fromId=77

// two pointer
class Solution {
public:
    /**
     * @param n: 
     * @param k: 
     * @param len: 
     * @param num: //same as problem
     * @return: //return long
     */
    long long solve(int n, int k, int len, vector<int> &num) {
        long long lim = k;
        lim *= len;
        long long sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
            if(i > len - 1 ){
                sum -= num[i - len];
            }
            
            if(i >= len - 1 && sum > lim){
                ++ ans;
            }
        }
        return ans;
    }
};