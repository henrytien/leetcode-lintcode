// https://www.lintcode.com/problem/single-number-ii/description

class Solution {
public:
    /**
     * @param A: An integer array
     * @return: An integer
     */
    int singleNumberII(vector<int> &A) {
        
        int one = 0;
        int two = 0;
        for (int i = 0; i < A.size(); i++) {
            one = (one ^ A[i]) & (~two);
            two = (two ^ A[i]) & (~one);
        }
        return one|two;
    }
};