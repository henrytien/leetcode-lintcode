// Source : https://leetcode.com/problems/word-ladder/
// Author : Kris
// Date   : 2020-07-30

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

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        
        // add beginWord
        wordList.add(beginWord);
        
        // remove duplicate
        wordList = wordList.stream().distinct().collect(Collectors.toList());
        
        // build graph
        var graph = buildGraph(wordList);
        
        // breadth first search
        return bfs(graph, beginWord, endWord);
    }
    
    Map<String, List<String>> buildGraph(List<String> wordList) {
        var graph = new HashMap<String, List<String>>();
        
        for (int i = 0; i < wordList.size(); i++) {
            var curWord = wordList.get(i);
            var list = new ArrayList<String>();
            graph.put(wordList.get(i), list);
            for (int j = 0; j < wordList.size(); j++) {
                if (canTransform(curWord, wordList.get(j))) {
                    list.add(wordList.get(j));
                }
            }
        }
        
        return graph;
    }
    
    boolean canTransform(String src, String dest) {
        if (src.length() != dest.length()) {
            return false;
        }
        
        var diff = 0;
        for (var i = 0; i < src.length(); i++) {
            if (src.charAt(i) != dest.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
    
    int bfs(Map<String, List<String>> graph, String beginWord, String endWord) {
        var queue = new LinkedList<String>();
        var visit = new HashSet<String>();
        
        var level = 0;
        queue.offer(beginWord);
        visit.add(beginWord);
        
        while (!queue.isEmpty()) {
            level++;
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                if (cur.equals(endWord)) {
                    return level;
                }
                
                var neighbors = graph.get(cur);
                for (var neighbor : neighbors) {
                    if (visit.contains(neighbor)) {
                        continue;
                    }
                    
                    queue.offer(neighbor);
                    visit.add(neighbor);
                }
            }
        }
        
        return 0;
    }
}