//https://www.lintcode.com/problem/first-bad-version/description?_from=ladder&&fromId=1

/**
 * class SVNRepo {
 *     public:
 *     static bool isBadVersion(int k);
 * }
 * you can use SVNRepo::isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
public:
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while(start + 1 < end)
        {
            int mid = start + (end - start) / 2;
            if(SVNRepo::isBadVersion(mid)){
                end = mid;
            }
            else
            {
               start = mid;
            }
        }
        if(SVNRepo::isBadVersion(start))
        {
            return start;
        }
        return end;
        
    }
};