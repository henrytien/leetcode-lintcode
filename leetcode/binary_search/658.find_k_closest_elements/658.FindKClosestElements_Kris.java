// Source : https://leetcode.com/problems/find-k-closest-elements/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The 
 * result should also be sorted in ascending order. If there is a tie, the smaller elements are always 
 * preferred.
 * 
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * 
 * Constraints:
 * 
 * 	1 <= k <= arr.length
 * 	1 <= arr.length <= 10^4
 * 	Absolute value of elements in the array and x will not exceed 104
 ******************************************************************************************************/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var result = new ArrayList<Integer>();
        if (arr == null || arr.length < k || k <= 0) {
            return result;
        }
        
        var start = 0;
        var end = arr.length - 1;
        while (start < end - 1) {
            var mid = start + (end - start) / 2;
            if (arr[mid] <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        var startIndex = start - k + 1 >= 0 ? start - k + 1 : 0;
        var heap = new PriorityQueue<Integer>(
            k, (a, b) -> Math.abs(b - x) - Math.abs(a - x));
        for (; startIndex < arr.length; startIndex++) {
            if (heap.size() < k) {
                heap.offer(arr[startIndex]);
            } else if (heap.size() == k 
                && Math.abs(heap.peek() - x) <= Math.abs(arr[startIndex] - x)) {
                break;
            } else {
                heap.offer(arr[startIndex]);
                heap.poll();
            }
        }
        
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.sort(result);
        
        return result;
    }
}