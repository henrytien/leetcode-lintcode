// https://www.lintcode.com/problem/3sum/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    vector<vector<int>> threeSum(vector<int> &numbers) {
        vector<vector<int>> res;
        int n = numbers.size();
        if(n < 3){
            return res;
        }
        
        sort(numbers.begin(),numbers.end());
        for (int i = 0; i < n -1; i++) {
            
           if(i > 0 && numbers[i] == numbers[i-1]){
               continue;
           }
           
           int start = i + 1, end = n-1;
           int target = 0 -numbers[i];
           // two sum 
           while(start < end){
               
               if(numbers[start] + numbers[end] == target){
                   res.push_back({numbers[i],numbers[start],numbers[end]});
                   // continue find
                   while(numbers[start] == numbers[start+1]) start++;
                   while(numbers[end] == numbers[end-1]) end--;
                   start++;
                   end--;
               }
               else if(numbers[start] + numbers[end] < target){
                   start++;
               }
               else{
                   end--;
               }
               
           }
        }
        
        return res;
    }
};