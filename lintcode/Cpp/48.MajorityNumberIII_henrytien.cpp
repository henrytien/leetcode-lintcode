// https://www.lintcode.com/problem/majority-number-iii/leaderboard
class Solution {
public:
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    int majorityNumber(vector<int> &nums, int k) {
        // write your code here
        int n = nums.size();
        //double flag = n / k;
        // for (int i = 0; i < n; i++) {
        //     int cnt = 0;
        //     for (int j = 0; j < n; j++) {
        //         if(nums[i] == nums[j]){
        //             cnt++;
        //         }
        //         if(cnt <= flag){
        //             continue;
        //         }
        //         else {
        //             return nums[i];
        //         }
        //     }
        // }
        
        //  map<int, int> mp;
        // int n = nums.size();
        // int m = n / k;
        // for( int cnt = 0; cnt < n; cnt++ ){
        //     mp[nums[cnt]]++;
        //     if( mp[nums[cnt]] > m )
        //         return nums[cnt];
        // }
        
        unordered_map<int,int> myHash;
        for (auto e : nums) {
            myHash[e] += 1;
            std::cout << myHash[e] / n << std::endl;
            if(myHash[e] > n/k){
                return e;
            }
        }
        
    }
};