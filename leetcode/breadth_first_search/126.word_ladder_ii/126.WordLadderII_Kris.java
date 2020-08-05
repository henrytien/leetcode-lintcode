// Source : https://leetcode.com/problems/word-ladder-ii/
// Author : Kris
// Date   : 2020-08-05

/***************************************************************************************************** 
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest 
 * transformation sequence(s) from beginWord to endWord, such that:
 * 
 * 	Only one letter can be changed at a time
 * 	Each transformed word must exist in the word list. Note that beginWord is not a transformed 
 * word.
 * 
 * Note:
 * 
 * 	Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 
 * Example 2:
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 ******************************************************************************************************/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return new ArrayList<List<String>>();
        }
        
        // add beginWord
        wordList.add(beginWord);
        
        // remove duplicate
        wordList = wordList.stream().distinct().collect(Collectors.toList());
        
        // build graph
        var graph = buildGraph(wordList);
        
        // breadth first search
        var myQueue = bfs(graph, beginWord, endWord);
        
        // build result from myQueue
        return buildResult(myQueue, endWord);
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
    
    List<Node> bfs(Map<String, List<String>> graph, String beginWord, String endWord) {
        var myQueue = new ArrayList<Node>();
        var visit = new HashMap<String, Integer>();
        var level = 0;
        
        // simulate a queue by list
        myQueue.add(new Node(beginWord, -1));
        visit.put(beginWord, level);
        
        var finish = false;
        var i = 0;
        while (i < myQueue.size()) {    
            level++;
            var size = myQueue.size();
            
            for (; i < size; i++) {
                var cur = myQueue.get(i);
                
                var neighbors = graph.get(cur.word);
                for (var neighbor : neighbors) {
                    if (neighbor.equals(cur.word)) {
                        finish = true;
                    }
                    
                    if (visit.containsKey(neighbor) && level != visit.get(neighbor)) {
                        continue;
                    }

                    myQueue.add(new Node(neighbor, i));
                    visit.put(neighbor, level);
                }
            }
            
            if (finish) {
                break;
            }
        }
        
        return myQueue;
    }
    
    List<List<String>> buildResult(List<Node> myQueue, String endWord) {
        myQueue.forEach(x -> System.out.print(x.word + ", "));
        
        var paths = new ArrayList<List<String>>();
        
        var lastNodes = new ArrayList<Node>();
        for (var i = 0; i < myQueue.size(); i++) {
            if (myQueue.get(i).word.equals(endWord)) {
                lastNodes.add(myQueue.get(i));
            }
        }
        
        for (var i = 0; i < lastNodes.size(); i++) {
            var one = new ArrayList<String>();
            
            var cur = lastNodes.get(i);
            while (cur.prePos != -1) {
                one.add(0, cur.word);
                cur = myQueue.get(cur.prePos);
            };
            one.add(0, cur.word);
            
            paths.add(one);
        }
        
        return paths;
    }
}

class Node {
    String word;
    int prePos;
    public  Node(String word, int prePos) {
        this.word = word;
        this.prePos = prePos;
    }
}