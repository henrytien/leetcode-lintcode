// https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    int deduplication(vector<int> &nums) {
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        
        sort(nums.begin(),nums.end());
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if(nums[slow] != nums[fast])
            {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
};


class Solution {
public:
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    int deduplication(vector<int> &nums) {
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        
       unordered_map<int,int> myHash;
       vector<int> res;
       for (int i = 0; i < n; i++) {
           if(myHash.find(nums[i]) == myHash.end())
           {
               myHash[nums[i]] = nums[i];
               res.push_back(nums[i]);
           }
       }
       nums = res;
       return res.size();
    }
};