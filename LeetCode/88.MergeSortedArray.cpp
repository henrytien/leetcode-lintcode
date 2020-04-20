// https://leetcode.com/problems/merge-sorted-array/
// two pointer 

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> res(m+n,0);
        int i = 0, j = 0, k = 0;
        if(m == 0){
            swap(nums1,nums2);
            return;
        } 
        if(n == 0){
            return;
        }

        while( i < m && j < n){
            if(nums1[i] < nums2[j]){
                res[k++] = nums1[i++];
            }else{
                res[k++] = nums2[j++];
            }

        }
        
        if(i != m){
            while(i < m){
                res[k++] = nums1[i++];
            }
        }

        if(j != n){
            while(j < n){
                res[k++] = nums2[j++];
            }
        }
       
        swap(nums1,res);
    }
};


// store the largest


class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0){
            nums1[k--] = (nums1[i] < nums2[j]) ? nums2[j--]:nums1[i--];
        }
        if(j >= 0){
            while(j>=0){
                nums1[k--] = nums2[j--];
            }
        }
        return;
    }
};