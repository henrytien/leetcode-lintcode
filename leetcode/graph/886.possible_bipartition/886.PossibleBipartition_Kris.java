// Source : https://leetcode.com/problems/possible-bipartition/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of 
 * any size.
 * 
 * Each person may dislike some other people, and they should not go into the same group. 
 * 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b 
 * into the same group.
 * 
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * 
 * Example 1:
 * 
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * 
 * Example 2:
 * 
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * 
 * Example 3:
 * 
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * 
 * Constraints:
 * 
 * 	1 <= N <= 2000
 * 	0 <= dislikes.length <= 10000
 * 	dislikes[i].length == 2
 * 	1 <= dislikes[i][j] <= N
 * 	dislikes[i][0] < dislikes[i][1]
 * 	There does not exist i != j for which dislikes[i] == dislikes[j].
 ******************************************************************************************************/

class Solution {
    // https://leetcode.com/problems/is-graph-bipartite/
    // 0: initial, 1: red, -1: green
    public boolean possibleBipartition(int N, int[][] dislikes) {
        var colors = new int[N + 1];
        var graph = new Set[N + 1];
        for (var i = 1; i <= N; i++) {
            graph[i] = new HashSet<Integer>();
        }
        
        for (var dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        
        for (var i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(graph, i, colors, 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean dfs(Set[] graph, int i, int[] colors, int color) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }
        
        colors[i] = color;
        
        Set<Integer> neighbors = graph[i];
        for (var neighbor : neighbors) {
            if (!dfs(graph, neighbor, colors, -color)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    // TLE
    public boolean possibleBipartition_TLE(int N, int[][] dislikes) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        
        return helper(dislikes, 0, set1, set2);
    }
    
    boolean helper(int[][] dislikes, int index, Set<Integer> set1, Set<Integer> set2) {
        if (index == dislikes.length) {
            return true;
        }
        
        var res = false;
        int first = dislikes[index][0], second = dislikes[index][1];
        if ((set1.contains(first) && set1.contains(second))
            || (set2.contains(first) && set2.contains(second))) {
            // System.out.println(set1);
            // System.out.println(set2);
            // System.out.println(first + ":" + second);
            // System.out.println();
            res = false;
        } else if (set1.contains(first)) {
            set2.add(second);
            res = helper(dislikes, index + 1, set1, set2);
            set2.remove(second);
        } else if (set1.contains(second)) {
            set2.add(first);
            res = helper(dislikes, index + 1, set1, set2);
            set2.remove(first);
        } else if (set2.contains(first)) {
            set1.add(second);
            res = helper(dislikes, index + 1, set1, set2);
            set1.remove(second);
        } else if (set2.contains(second)) {
            set1.add(first);
            res = helper(dislikes, index + 1, set1, set2);
            set1.remove(first);
        } else {
            // !set1.contains(first) && !set1.contains(second)
            // && !set2.contains(first) && !set2.contains(second)
            set1.add(first);
            set2.add(second);
            
            res = helper(dislikes, index + 1, set1, set2);
            set1.remove(first);
            set2.remove(second);
            if (res) {
                return true;
            }

            set1.add(second);
            set2.add(first);
            res = helper(dislikes, index + 1, set1, set2);
            set1.remove(second);
            set2.remove(first);
        }
        
        return res;
    }
}