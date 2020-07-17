// https://leetcode.com/problems/task-scheduler/
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<int,int> mp;
        int count = 0; // frequency
        for(auto e: tasks){
            mp[e]++;
            count = max(count,mp[e]);
        }
        
        int ans = (count - 1) * (n + 1);
        for(auto e: mp){
            if(count == e.second) ans++;
        }
        return max((int)tasks.size(),ans);
            
    }
};