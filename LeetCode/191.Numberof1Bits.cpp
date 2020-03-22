// https://leetcode.com/problems/number-of-1-bits/

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int num = 0;
        while(n){
            num++;
            n &= (n-1);
        }
        return num;
    }
};