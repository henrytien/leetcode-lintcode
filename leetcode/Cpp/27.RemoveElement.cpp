// https://leetcode.com/problems/remove-element/
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
    int start = 0, end = nums.size();
    while(start < end){
        if(nums[start] == val){
            nums[start] = nums[end -1];
            end--;
        }else{
            start++;
        }
    }
    return end;
    }
};

// class Solution {
// public:
//     int removeElement(vector<int>& nums, int val) {
//     int j = 0;
      
//       for(int i = 0; i < nums.size() ; ++i){
//           if( nums[i] != val){
//               nums[j] = nums[i];
//               j++;
//           }
        
//       }
//       return j;
//     }
// };