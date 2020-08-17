// Source : https://leetcode.com/problems/top-k-frequent-words/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same 
 * frequency, then the word with the lower alphabetical order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 &le; k &le; number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 ******************************************************************************************************/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        var result = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        var map = new HashMap<String, Integer>();
        for (var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 求最大的k个，应该用MinHeap
        var queue = new PriorityQueue<String>(k + 1, (x, y) -> {
            if (map.get(x).equals(map.get(y))) {
                // 结果保留字母序靠前的
                return y.compareTo(x);
            } else {
                return map.get(x) - map.get(y);
            }
        });
        
        for (var key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        
        return result;
    }
}