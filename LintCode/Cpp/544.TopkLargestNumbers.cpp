// https://www.lintcode.com/problem/top-k-largest-numbers/description?_from=ladder&&fromId=1

// heap
class Solution {
public:
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    bool static compare(const int& a, const int& b){
        return a > b;
    }
     
    vector<int> topk(vector<int> &nums, int k) {
        priority_queue<int,vector<int>, greater<int>> priority_queue;
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            priority_queue.push(nums[i]);
        }
        
        
        for (int i = k; i < n; i++) {
            if(nums[i] > priority_queue.top()){
                priority_queue.pop();
                priority_queue.push(nums[i]);
            }
        }
        vector<int> res;
        for (int i = 0; i < k; i++) {
            res.push_back(priority_queue.top());
            priority_queue.pop();
        }
        
        sort(res.begin(),res.end(),compare);
        //sort(res.rbegin(),res.rend());
        return res;
    }
    
    //  vector<int> topk(vector<int> &nums, int k) {
    //     sort(nums.rbegin(),nums.rend());
    //     vector<int> res;
    //     for (int i = 0; i < k; i++) {
    //         res.push_back(nums[i]);
    //     }
        
    //     return res;
    // }
};