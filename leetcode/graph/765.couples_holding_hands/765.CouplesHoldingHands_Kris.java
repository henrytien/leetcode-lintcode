// Source : https://leetcode.com/problems/couples-holding-hands/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * 
 * N couples sit in 2N seats arranged in a row and want to hold hands.  We want to know the minimum 
 * number of swaps so that every couple is sitting side by side.  A swap consists of choosing any two 
 * people, then they stand up and switch seats. 
 * 
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in 
 * order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last 
 * couple being (2N-2, 2N-1).
 * 
 * The couples' initial seating is given by row[i] being the value of the person who is initially 
 * sitting in the i-th seat.
 * 
 * Example 1:
 * Input: row = [0, 2, 1, 3]
 * Output: 1
 * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 * 
 * Example 2:
 * Input: row = [3, 2, 0, 1]
 * Output: 0
 * Explanation: All couples are already seated side by side.
 * 
 * Note:
 * 
 *  len(row) is even and in the range of [4, 60].
 *  row is guaranteed to be a permutation of 0...len(row)-1.
 ******************************************************************************************************/

class Solution {
    // Greedy O(n)
    /* The proof is easy. Consider a simple example: 7 1 4 6 2 3 0 5. At first step we have two choice to match the first couple: swap 7 with 0, or swap 1 with 6. Then we get 0 1 4 6 2 3 7 5 or 7 6 4 1 2 3 0 5. Pay attention that the first couple doesn't count any more. For the later part it is composed of 4 X 2 3 Y 5 (X=6 Y=7 or X=1 Y=0). Since different couples are unrelated, we don't care X Y is 6 7 pair or 0 1 pair. They are equivalent! */
    public int minSwapsCouples(int[] row) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }
        
        var count = 0;
        for (var i = 0; i < row.length; i += 2) {
            var couple = getCouple(row[i]);
            if (row[i + 1] != couple) {
                var j = map.get(couple);
                swap(row, i + 1, j, map);
                
                count++;
            }
        }
        
        return count;
    }
    
    int getCouple(int a) {
        if (a % 2 == 0) {
            return a + 1;
        } else {
            return a - 1;
        }
    }
    
    void swap(int[] row, int i, int j, Map<Integer, Integer> map) {
        if (i != j) {
            map.put(row[i], j);
            map.put(row[j], i);
            row[i] = row[i] ^ row[j];
            row[j] = row[i] ^ row[j];
            row[i] = row[i] ^ row[j];
        }
    }
}