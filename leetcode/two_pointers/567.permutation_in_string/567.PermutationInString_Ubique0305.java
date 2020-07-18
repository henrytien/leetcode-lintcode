// Source : https://leetcode.com/problems/permutation-in-string/
// Author : Ubique0305
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.
 * 
 * Example 1:
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * Example 2:
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * Constraints:
 * 
 * 	The input strings only contain lower case letters.
 * 	The length of both given strings is in range [1, 10,000].
 ******************************************************************************************************/

/*
 * 1. 枚举所有可能,对每一个可能去search
 * 2. hash
 * 3. 字符数组替代哈希
 * 4. 滑动窗口
 */
public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[256];
        for(char a : s1.toCharArray()){
            map[a]++;
        }
        int left = 0,match = 0,minLen = Integer.MAX_VALUE;
        for(int right = 0;right < s2.length();right++){
            if(map[s2.charAt(right)]-- > 0){
                match++;
            }
            if(match == s1.length()){
                while(map[s2.charAt(left)] < 0){
                    map[s2.charAt(left)]++;
                    left++;
                }
                minLen = minLen > (right - left + 1) ? right - left + 1 : minLen;
                map[s2.charAt(left)]++;
                left++;
                match--;
            }
        }
        return minLen == s1.length() ? true : false;
    }



