// https://www.lintcode.com/problem/search-for-a-range/description
class Solution {
public:
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    vector<int> searchRange(vector<int> &A, int target) {
        
        int start = lower_bound(A,target);
        
        if(start == A.size() || A[start] != target){
            return {-1,-1};
        }
        int end = lower_bound(A,target + 1) - 1;
        
        return {start,end};
        
    }
    
private:
    int lower_bound(vector<int> &A, int target){
        int left = 0, right = A.size() - 1;
        int index = A.size();
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] >= target){
                index = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return index;
    }
    
};