//https://www.lintcode.com/problem/search-in-rotated-sorted-array-ii/description
// binary search
class Solution {
public:
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    bool search(vector<int> &A, int target) {
        int size = A.size();
        if(size == 0){
            return false;
        }
        // sort(A.begin(),A.end());
        int start = 0, end = size -1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(A[start] == target || A[end] == target){
                return true;
            }
            
            if(A[mid] == target){
                return true;
            }
            
            if(A[mid] < target){
                start = mid + 1;
            }else{
               end = mid - 1; 
            }
        }
        return false;
    }
};