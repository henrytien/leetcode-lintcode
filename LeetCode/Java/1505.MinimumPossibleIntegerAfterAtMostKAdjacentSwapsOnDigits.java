// Source : https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/
// Author : Ubique0305
// Date   : 2020-07-06

/***************************************************************************************************** 
 *
 * Given a string num representing the digits of a very large integer and an integer k.
 * 
 * You are allowed to swap any two adjacent digits of the integer at most k times.
 * 
 * Return the minimum integer you can obtain also as a string.
 * 
 * Example 1:
 * 
 * Input: num = "4321", k = 4
 * Output: "1342"
 * Explanation: The steps to obtain the minimum integer from 4321 with 4 adjacent swaps are shown.
 * 
 * Example 2:
 * 
 * Input: num = "100", k = 1
 * Output: "010"
 * Explanation: It's ok for the output to have leading zeros, but the input is guaranteed not to have 
 * any leading zeros.
 * 
 * Example 3:
 * 
 * Input: num = "36789", k = 1000
 * Output: "36789"
 * Explanation: We can keep the number without any swaps.
 * 
 * Example 4:
 * 
 * Input: num = "22", k = 22
 * Output: "22"
 * 
 * Example 5:
 * 
 * Input: num = "9438957234785635408", k = 23
 * Output: "0345989723478563548"
 * 
 * Constraints:
 * 
 * 	1 <= num.length <= 30000
 * 	num contains digits only and doesn't have leading zeros.
 * 	1 <= k <= 10^9
 ******************************************************************************************************/
class Solution {
    public String minInteger(String num, int k) {
		StringBuffer ans = new StringBuffer();
		int n = num.length();
		HashSet<Integer> set = new HashSet<>();
        // 记录数字下标
		LinkedList<Integer>[] list = new LinkedList[10];
		for(int i=0;i<10;i++) {
			list[i]=new LinkedList<Integer>();
		}
		for(int i=n-1;i>=0;i--) {
			list[num.charAt(i)-48].push(i);
		}
        // 查询移动次数
		FenwichTree fenwichTree = new FenwichTree(new int[n]);
		while(k>0&&ans.length()<n) {
			for(int i=0;i<10;i++) {
				Integer peek = list[i].peek();
                //是否可以移动
				if(peek!=null&&peek<=k+fenwichTree.preSum(peek)) {
					set.add(peek);
					ans.append(num.charAt(peek));
					list[i].poll();
					k-=peek-fenwichTree.preSum(peek);
					fenwichTree.update(peek, 1);
					break;
				}
			}
		}
		for(int i=0;i<n;i++) {
			if(!set.contains(i)) {
				ans.append(num.charAt(i));
			}
		}
		return ans.toString();
    }


	class FenwichTree {
		  private int[] sums;
		  private int[] nums;

		  public FenwichTree(int[] nums) {
		        this.sums = new int[nums.length + 1];
		        this.nums = nums;
                for (int i = 0; i < nums.length; i++) {
                  updateBit(i + 1, nums[i]);
                }
              }

		  public void update(int i, int val) {
                updateBit(i + 1, val - nums[i]);
                nums[i] = val;
		  }

		  private void updateBit(int i, int diff) {
                while (i < sums.length) {
                  sums[i] += diff;
                  i += lowBit(i);
                }
		  }

		  public int sumRange(int i, int j) {
		        return preSum(j + 1) - preSum(i);
		  }

		  private int preSum(int i) {
                int sum = 0;
                while (i > 0) {
                  sum += sums[i];
                  i -= lowBit(i);
                }
                return sum;
		  }

		  private int lowBit(int i) {
		    return i & (-i);
		  }
		}
}


