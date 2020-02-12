// https://www.lintcode.com/problem/majority-element-ii/description
class Solution {
public:
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    int majorityNumber(vector<int> &nums) {
        int n = nums.size();
        if(n == 0){
            return 0;
        }
       unordered_map<int,int> myHash;
       for (auto e : nums) {
           myHash[e] += 1;
           if(myHash[e] > n/3 ){
               return e;
           }
       }
       
       return 0;
    }
};