// Source : https://leetcode.com/problems/word-ladder/
// Author: Eve
// Date: 2020-07-31

/***************************************************************************************************** 
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, such that:
 * 
 * 	Only one letter can be changed at a time.
 * 	Each transformed word must exist in the word list.
 * 
 * Note:
 * 
 * 	Return 0 if there is no such transformation sequence.
 * 	All words have the same length.
 * 	All words contain only lowercase alphabetic characters.
 * 	You may assume no duplicates in the word list.
 * 	You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * Example 1:
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Example 2:
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 ******************************************************************************************************/

// BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // Delete the duplicates.
        Set<String> set = new HashSet<>(wordList);
        // Add the potentil words.
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // Count the steps.
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Traverse every word in the same level.
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // Terminate.
                if (word.equals(endWord)) {
                    return count;
                }
                // Check the validation.
                isValid(word, set, queue);
            }
            // Begin another round.
            count++;
        }
        return 0;
    }
    
    private void isValid(String word, Set<String> set, Queue<String> queue) {
        // Loop over the word and check all the characters.
        for (int i = 0; i < word.length(); i++) {
            // Change the string to list of characters.
            char[] chr = word.toCharArray();
            // Try all the possibilities.
            for (char j = 'a'; j <= 'z'; j++) {
                if (chr[i] == j) {
                    continue;
                }
                chr[i] = j;
                // Transform characters to string.
                String newWord = String.valueOf(chr);
                // If the word is in the word list, we can use it.
                // Delete it from the set to avoid repeated calculation.
                if (set.contains(newWord)) {
                    set.remove(newWord);
                    queue.offer(newWord);
                }
            }
        }
        
    }
}
// Time Complexity: O(m * 26 * n), m is the length of words, n is the number of words.
// Space Complexity: O(m * 26 * n)


