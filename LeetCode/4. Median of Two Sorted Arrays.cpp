//[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)


#include <iostream>
#include <vector>
#include <algorithm>
using  std::vector;
using  std::sort;
class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		sort(nums1.begin(), nums1.end());
		sort(nums2.begin(), nums2.end());
		float res = 0;
		for (vector<int>::iterator it = nums2.begin(); it != nums2.end(); ++it)
		{
			nums1.push_back(*it);
		}
		sort(nums1.begin(), nums1.end());
		int mid = nums1.size() / 2;
		if (nums1.size() % 2 == 0)
		{
			res = (nums1[mid - 1] + nums1[mid]) / 2.0;
		}
		else
		{
			res = nums1[mid];
		}

		return res;
	}
};
int main() {
	Solution a;
	vector<int> nums1({});
	vector<int> nums2({ 3,4 });
	a.findMedianSortedArrays(nums1, nums2);
	std::cout << "Hello, World!" << std::endl;
	return 0;
}



// log(n) 切割
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();

        if (m > n)  
		{
			return findMedianSortedArrays(nums2, nums1);
		}

        int lMax1, lMax2, rMin1, rMin2, c1, c2, lo = 0, hi = 2 * m;
        
        while(lo <= hi){

            c1 = (lo + hi) / 2;
            c2 = m + n - c1;

            lMax1 = (c1 == 0)? INT_MIN:(nums1[(c1 - 1)/2]);
            rMin1 = (c1 == 2 * m) ? INT_MAX : (nums1[c1/2]);
            lMax2 = (c2 == 0) ? INT_MIN : (nums2[(c2 - 1) / 2 ]);
            rMin2 = (c2 == n * 2) ? INT_MAX : (nums2[(c2/2)]);

            if(lMax1 > rMin2)
                hi = c1 - 1;
            else if(rMin1 < lMax2)
                lo = c1 + 1;
            else
                break;   

        }
        return (max(lMax1,lMax2) + min(rMin1, rMin2)) / 2.0;

    }
};

