// Source : https://leetcode.com/problems/concatenated-words/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated 
 * words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words 
 * in the given array.
 * 
 * Example:
 * 
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";  "dogcatsdog" can be 
 * concatenated by "dog", "cats" and "dog"; "ratcatdogcat" can be concatenated by "rat", "cat", "dog" 
 * and "cat".
 * 
 * Note:
 * 
 * The number of elements of the given array will not exceed 10,000 
 * The length sum of elements in the given array will not exceed 600,000. 
 * All the input string will only include lower case letters.
 * The returned elements order does not matter. 
 * 
 ******************************************************************************************************/

class Solution {    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        var root = new Node();
        for (var word : words) {
            addWord(root, word);
        }
        
        var result = new ArrayList<String>();
        for (var word : words) {
            if (findWord(root, word).count >= 2) {
                result.add(word);
            }
            // System.out.println(word + ":" + findWord(root, word).count);
        }
        
        return result;
    }
    
    void addWord(Node root, String word) {
        for (var i = 0; i < word.length(); i++) {
            if (root.nodes[word.charAt(i) - 'a'] == null) {
                root.nodes[word.charAt(i) - 'a'] = new Node();
            }
            root = root.nodes[word.charAt(i) - 'a'];
        }
        
        root.isEnd = true;
    }
    
    ReturnType findWord(Node root, String word) {
       if (word.length() == 0) {
            return new ReturnType(true, 0);
        }

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            cur = cur.nodes[word.charAt(i) - 'a'];
            if (cur == null) {
                return new ReturnType(false, -1);
            }

            if (cur.isEnd) {
                ReturnType result = findWord(root, word.substring(i + 1));
                if (result.find) {
                    return new ReturnType(true, result.count + 1);
                }
            }
        }

        return new ReturnType(false, -1);
    }
}

class ReturnType {
    public boolean find;
    public int count;
    
    public ReturnType(boolean find, int count) {
        this.find = find;
        this.count = count;
    }
}

class Node {
    public boolean isEnd;
    public Node[] nodes = new Node[26];
}